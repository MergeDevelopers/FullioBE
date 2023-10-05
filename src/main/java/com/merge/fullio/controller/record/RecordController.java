package com.merge.fullio.controller.record;

import com.merge.fullio.DTO.record.CategoryRequest;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.service.record.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class RecordController {

    private final RecordService recordService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody CategoryRequest categoryRequest){
        recordService.createCategory(principalDetails.getUser(), categoryRequest);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubCategory(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody CategoryRequest categoryRequest,
            @PathVariable  Long id){
        recordService.createSubCategory(principalDetails.getUser(), categoryRequest, id);
    }

}
