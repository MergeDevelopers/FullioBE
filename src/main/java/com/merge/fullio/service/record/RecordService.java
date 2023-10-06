package com.merge.fullio.service.record;

import com.merge.fullio.DTO.record.CategoryDTO;
import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._400.ExistEntityException;
import com.merge.fullio.model.record.Category;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO createDefaultCategory(){
        String defaultCategoryName = "category";
        int defaultLocation = 0;
        Category category = new Category(defaultCategoryName, defaultLocation);
        categoryRepository.save(category);
        return convertToDTO(category);
    }
    public void createCategory(User user, CategoryRequest categoryRequest) {
        Optional<Category> categoryOptional = categoryRepository.findByCreatedByAndLocationAndSubCategoriesIsEmpty(user, categoryRequest.getLocation());
        if(categoryOptional.isPresent()) throw new ExistEntityException(categoryRequest.getTitle(), Category.class);
        else {
            Category category = new Category(categoryRequest.getTitle(), categoryRequest.getLocation());
            categoryRepository.save(category);
        }
    }

    //TODO : 리퀘스트의 로케이션과 부모카테고리를 기준으로 중복이 없는지 체크
    public void createSubCategory(User user, CategoryRequest categoryRequest, Long id){
        Optional<Category> parentCategory = categoryRepository.findById(id);
        if(parentCategory.isPresent()){
            Category subCategory = new Category(categoryRequest.getTitle(), parentCategory.get(), categoryRequest.getLocation());
            parentCategory.get().addSubCategory(subCategory);

            categoryRepository.save(subCategory);
        } else {
            throw new BadRequestException(categoryRequest.getTitle());
        }
    }

    // 부모 카테고리에 하위 카테고리 추가
    private void addSubCategory(Long parentId, Long subCategoryId) {
        Category parentCategory = categoryRepository.findById(parentId).orElse(null);
        Category subCategory = categoryRepository.findById(subCategoryId).orElse(null);

        if (parentCategory != null && subCategory != null) {
            parentCategory.addSubCategory(subCategory);
            categoryRepository.save(parentCategory);
        }
    }

    //상위카테고리 변경
    @Transactional
    public void changeParentCategory(Long categoryId, Long newParentCategoryId) {
        // 변경할 카테고리를 데이터베이스에서 조회합니다.
        Category category = categoryRepository.findById(categoryId).orElse(null);

        // 새로운 부모 카테고리를 데이터베이스에서 조회합니다.
        Category newParentCategory = categoryRepository.findById(newParentCategoryId).orElse(null);

        if (category != null && newParentCategory != null) {
            // 변경할 카테고리의 부모 카테고리를 새로운 부모 카테고리로 설정합니다.
            category.setCategory(newParentCategory);

            // 변경한 카테고리를 데이터베이스에 저장합니다.
            categoryRepository.save(category);
        } else {
            // 카테고리 또는 새로운 부모 카테고리가 존재하지 않을 경우 예외 처리 또는 오류 처리를 수행할 수 있습니다.
            throw new BadRequestException();
        }
    }

    // 카테고리 검색
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 카테고리 검색 by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // 카테고리 삭제
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategories(User user) {
        Optional<Category> category = categoryRepository.findCategoriesByCreatedByAndLocation(user, 0);
        if(category.isPresent()) {
            CategoryDTO categoryDTO = convertToDTO(category.get());
            return categoryDTO;
        } else {
            return createDefaultCategory();
        }
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getName());
        categoryDTO.setLocation(category.getLocation());

        for (Category subCategory : category.getSubCategories()) {
            CategoryDTO subCategoryDTO = convertToDTO(subCategory);
            categoryDTO.getSubCategories().add(subCategoryDTO);
        }
        return categoryDTO;
    }
}
