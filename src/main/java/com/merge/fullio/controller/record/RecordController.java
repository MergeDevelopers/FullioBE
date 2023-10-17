package com.merge.fullio.controller.record;

import com.merge.fullio.DTO.ResponseCategoryData;
import com.merge.fullio.DTO.record.CategoryDTO;
import com.merge.fullio.DTO.record.CategoryProjectionResDTO;
import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class RecordController {

    private final RecordService recordService;

    /*@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody CategoryRequest categoryRequest){
        recordService.createCategory(principalDetails.getUser(), categoryRequest);
    }*/

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubCategory(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody CategoryRequest categoryRequest,
            @PathVariable  Long id){
        recordService.createSubCategory(principalDetails.getUser(), categoryRequest, id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseCategoryData<CategoryDTO> getCategories(
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        CategoryDTO categoryDTO = recordService.getCategories(principalDetails.getUser());

        return new ResponseCategoryData<>(categoryDTO);
    }

    @GetMapping("/projection")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryProjectionResDTO> getProjectionCategories(
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        List<CategoryProjectionResDTO> categoryProjectionResDTOList = recordService.getProjectionCategories(principalDetails.getUser());
        return categoryProjectionResDTOList;
    }

    /*@GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @PathVariable Long id) {

    }*/

}
