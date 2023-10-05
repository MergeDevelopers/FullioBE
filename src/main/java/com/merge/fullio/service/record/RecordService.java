package com.merge.fullio.service.record;

import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._400.ExistEntityException;
import com.merge.fullio.model.record.Category;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final CategoryRepository categoryRepository;

    public void createCategory(User user, CategoryRequest categoryRequest) {
        Optional<Category> categoryOptional = categoryRepository.findByCreatedByAndLocationAndSubCategoriesIsEmpty(user, categoryRequest.getLocation());
        if(categoryOptional.isPresent()) throw new ExistEntityException(categoryRequest.getTitle(), Category.class);
        else {
            Category category = new Category(categoryRequest.getTitle(), categoryRequest.getLocation());
            categoryRepository.save(category);
        }
    }

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
}
