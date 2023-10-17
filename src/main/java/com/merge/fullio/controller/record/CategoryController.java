package com.merge.fullio.controller.record;

import com.merge.fullio.DTO.record.CategoryProjectionResDTO;
import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.service.record.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubCategory(
            @RequestBody CategoryRequest categoryRequest,
            @PathVariable  Long id,
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        categoryService.createSubCategory(principalDetails.getUser(), categoryRequest, id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryProjectionResDTO> getProjectionCategories(
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        List<CategoryProjectionResDTO> categoryProjectionResDTOList = categoryService.getProjectionCategories(principalDetails.getUser());
        return categoryProjectionResDTOList;
    }

    @PutMapping("/{topId}/{subId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryProjectionResDTO> changeTopCategory(
            @PathVariable Long topId,
            @PathVariable Long subId,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        categoryService.changeParentCategory(subId, topId);
        List<CategoryProjectionResDTO> categoryProjectionResDTOList = categoryService.getProjectionCategories(principalDetails.getUser());
        return categoryProjectionResDTOList;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(
            @PathVariable Long id,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        categoryService.deleteCategory(principalDetails.getUser(), id);
    }

}
