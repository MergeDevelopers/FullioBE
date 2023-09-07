package com.merge.fullio.service.mainInfo;

import com.merge.fullio.DTO.strength.*;
import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._400.EntityNotFoundException;
import com.merge.fullio.model.strength.Skill;
import com.merge.fullio.model.strength.Strength;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.SkillRepository;
import com.merge.fullio.repository.StrengthRepository;
import com.merge.fullio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainInfoService {
    private final UserRepository userRepository;
    private final StrengthRepository strengthRepository;
    private final SkillRepository skillRepository;

    public UserDTO getUserInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        return new UserDTO(user1.getId(), user1.getUsername(), user1.getName(), user1.getNickName(), user1.getEmail(), user1.getPhoneNumber());
    }

    public StrengthDTO getStrengthInfo(User user){
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isPresent()){
            Strength strength = strengthOptional.get();
            return new StrengthDTO(strength.getId(), strength.getStrength_1(), strength.getStrength_2(), strength.getStrength_3(), strength.getStrength_4(), strength.getStrength_5());
        } else {
            return new StrengthDTO();
        }

    }

    public void saveStrength(StrengthRequest strengthRequest, User user){
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isEmpty()){
            Strength strength = new Strength(strengthRequest);
            strengthRepository.save(strength);
        } else {
            Strength strength = strengthOptional.get();
            strength.setStrength(strengthRequest);
        }
    }

    public void updateStrength(StrengthRequest strengthRequest, User user){
        Strength strength = strengthRepository.findByCreatedBy(user)
                .orElseThrow(() -> new EntityNotFoundException());
        strength.setStrength(strengthRequest);
        strengthRepository.save(strength);
    }

    public SkillDTO getSkillInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        Optional<Skill> skillOptional = skillRepository.findByCreatedBy(user1);
        if(skillOptional.isPresent()){
            Skill skill = skillOptional.get();
            return new SkillDTO(skill.getSkill_1(),skill.getSkill_2(),skill.getSkill_3(),skill.getSkill_4());
        } else {
            return new SkillDTO();
        }

    }

    public void saveSkill(SkillRequest skillRequest, User user){
        Optional<Skill> skillOptional = skillRepository.findByCreatedBy(user);
        if(skillOptional.isEmpty()){
            Skill skill = new Skill(skillRequest);
            skillRepository.save(skill);
        } else {
            Skill skill = skillOptional.get();
            skill.setSkill(skillRequest);
            skillRepository.save(skill);
        }
    }

    public void updateSkill(SkillRequest skillRequest, User user){
        Skill skill = skillRepository.findByCreatedBy(user)
                .orElseThrow(() -> new EntityNotFoundException());
        skill.setSkill(skillRequest);
        skillRepository.save(skill);
    }

    public MottoDTO getMottoInfo(User user){
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isPresent()){
            Strength strength = strengthOptional.get();
            return new MottoDTO(strength.getMotto());
        } else {
            return new MottoDTO();
        }
    }

    public void saveMotto(MottoRequest mottoRequest, User user) {
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user);
        if(strengthOptional.isEmpty()){
            Strength strength = new Strength(mottoRequest.getMotto());
            strengthRepository.save(strength);
        } else {
            Strength strength = strengthOptional.get();
            strength.setMotto(mottoRequest.getMotto());
            strengthRepository.save(strength);
        }
    }

    public void updateMotto(MottoRequest mottoRequest, User user) {
        Strength strength = strengthRepository.findByCreatedBy(user)
                .orElseThrow(() ->new EntityNotFoundException());

        strength.setMotto(mottoRequest.getMotto());
        strengthRepository.save(strength);
    }
}
