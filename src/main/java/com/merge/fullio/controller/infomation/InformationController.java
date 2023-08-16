package com.merge.fullio.controller.infomation;

import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.model.user.ResponseData;
import com.merge.fullio.service.user.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
public class InformationController {

    private final InfoService infoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResponseData<UserDTO> getUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        UserDTO userDTO = infoService.getUserInfo(principalDetails.getUser());
        return new ResponseData<>(userDTO);
    }
}
