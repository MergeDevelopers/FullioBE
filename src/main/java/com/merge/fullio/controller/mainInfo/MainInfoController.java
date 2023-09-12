package com.merge.fullio.controller.mainInfo;

import com.merge.fullio.DTO.strength.*;
import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.config.auth.PrincipalDetails;
import com.merge.fullio.model.strength.Skill;
import com.merge.fullio.model.user.ResponseData;
import com.merge.fullio.service.mainInfo.MainInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
@RequestMapping("/main")
public class MainInfoController {

    private final MainInfoService mainInfoService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        UserDTO userDTO = mainInfoService.getUserInfo(principalDetails.getUser());
        return userDTO;
    }

    @GetMapping("/strength")
    @ResponseStatus(HttpStatus.OK)
    public StrengthDTO getStrengthInfo(
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        StrengthDTO strengthDTO = mainInfoService.getStrengthInfo(principalDetails.getUser());
        return strengthDTO;
    }

    @PostMapping("/strength")
    @ResponseStatus(HttpStatus.CREATED)
    public void inputStrength(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody StrengthRequest strengthRequest){
        mainInfoService.saveStrength(strengthRequest, principalDetails.getUser());
    }

    @PutMapping("/strength")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStrength(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody StrengthRequest strengthRequest) {
        mainInfoService.updateStrength(strengthRequest, principalDetails.getUser());
    }

    @GetMapping("/skill")
    @ResponseStatus(HttpStatus.OK)
    public SkillDTO getSkill(
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return mainInfoService.getSkillInfo(principalDetails.getUser());
    }

    @PostMapping("/skill")
    @ResponseStatus(HttpStatus.CREATED)
    public void inputSkills(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody SkillRequest skillRequest){
        mainInfoService.saveSkill(skillRequest, principalDetails.getUser());
    }

    @PutMapping("/skill")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSkills(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody SkillRequest skillRequest){
        mainInfoService.updateSkill(skillRequest,principalDetails.getUser());
    }

    @GetMapping("/motto")
    @ResponseStatus(HttpStatus.OK)
    public MottoDTO getMotto(
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return mainInfoService.getMottoInfo(principalDetails.getUser());
    }

    @PostMapping("/motto")
    @ResponseStatus(HttpStatus.CREATED)
    public void inputMotto(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody MottoRequest mottoRequest) {
        mainInfoService.saveMotto(mottoRequest, principalDetails.getUser());
    }

    @PutMapping("/motto")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotto(
            @AuthenticationPrincipal PrincipalDetails principalDetails,
            @RequestBody MottoRequest mottoRequest) {
        mainInfoService.updateMotto(mottoRequest, principalDetails.getUser());
    }

}
