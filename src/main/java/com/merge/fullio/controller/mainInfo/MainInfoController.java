package com.merge.fullio.controller.mainInfo;

import com.merge.fullio.DTO.skill.SkillDTO;
import com.merge.fullio.DTO.strength.StrengthDTO;
import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.model.user.ResponseData;
import com.merge.fullio.service.mainInfo.MainInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainInfoController {

    private final MainInfoService mainInfoService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserDTO> getUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        UserDTO userDTO = mainInfoService.getUserInfo(principalDetails.getUser());
        return new ResponseData<>(userDTO);
    }

    @GetMapping("/strength")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<StrengthDTO> getStrengthInfo(
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        StrengthDTO strengthDTO = mainInfoService.getStrengthInfo(principalDetails.getUser());
        return new ResponseData<>(strengthDTO);
    }

    @PostMapping("/strength")
    @ResponseStatus(HttpStatus.CREATED)
    public void inputStrength(
            @AuthenticationPrincipal PrincipalDetails principalDetails){

    }

    @GetMapping("/skill")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<SkillDTO> getSkillInfo(
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        SkillDTO skillDTO = mainInfoService.getSkillInfo(principalDetails.getUser());
        return new ResponseData<>(skillDTO);
    }
}
