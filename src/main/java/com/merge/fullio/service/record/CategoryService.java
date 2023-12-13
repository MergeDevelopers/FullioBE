package com.merge.fullio.service.record;

import com.merge.fullio.DTO.record.CategoryProjectionResDTO;
import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.exception.BaseResponseStatus;
import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._400.EntityNotFoundException;
import com.merge.fullio.exception.clienterror._400.ExistEntityException;
import com.merge.fullio.model.records.Category;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private CategoryProjectionResDTO createDefaultCategory(){
        String defaultCategoryName = "category";
        int defaultLocation = 0;
        Category category = new Category(defaultCategoryName, defaultLocation);
        categoryRepository.save(category);
        return categoryRepository.findProjectionById(category.getId());
    }

    //리퀘스트의 로케이션과 부모카테고리를 기준으로 중복이 없는지 체크
    public void createSubCategory(User user, CategoryRequest categoryRequest, Long id){
        Optional<Category> topCategory = categoryRepository.findById(id);
        if(topCategory.isPresent()){
            //중복체크 후 없으면 저장
            boolean categoryCheck = categoryRepository.existsByCreatedByAndLocationAndCategory(user, categoryRequest.getLocation(), topCategory.get());
            if(!categoryCheck){
                Category subCategory = new Category(categoryRequest.getTitle(), topCategory.get(), categoryRequest.getLocation());
                topCategory.get().addSubCategory(subCategory);
                categoryRepository.save(subCategory);
            } else {
                throw new ExistEntityException(BaseResponseStatus.EXIST_ENTITY);
            }

        } else {
            throw new BadRequestException(BaseResponseStatus.BAD_REQUEST);
        }
    }

    //상위카테고리 변경
    @Transactional
    public void changeParentCategory(Long categoryId, Long newTopCategoryId) {
        // 변경할 카테고리를 데이터베이스에서 조회
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.EXIST_ENTITY)
        );

        // 새로운 부모 카테고리를 데이터베이스에서 조회
        Category newTopCategory = categoryRepository.findById(newTopCategoryId).orElseThrow(
                () -> new EntityNotFoundException(BaseResponseStatus.ENTITY_NOT_FOUND)
        );
        //저장(더티체킹)
        category.setCategory(newTopCategory);

    }

    //카테고리 목록을 반환
    @Transactional
    public List<CategoryProjectionResDTO> getProjectionCategories(User user) {
        boolean categoryCheck = categoryRepository.existsCategoriesByCreatedByAndLocation(user, 0);
        if(!categoryCheck) {
            createDefaultCategory();
        }
        List<CategoryProjectionResDTO> categoryProjectionResDTOList = categoryRepository.findProjectionCategories(user.getId());
        return categoryProjectionResDTOList;
    }

    //하위 카테고리가 없는 경우 삭제
    public void deleteCategory(User user, Long categoryId) {
        // 하위 카테고리가 없는 경우에만 카테고리 삭제
        if (categoryRepository.countSubCategoriesByCategoryIdAndCreatedBy(categoryId, user) == 0) {
            categoryRepository.deleteById(categoryId);
        } else {
            //TODO: 하위 카테고리가 있는경우 예외처리
            throw new BadRequestException(BaseResponseStatus.EXIST_SUB_CATEGORY);
        }
    }

}
