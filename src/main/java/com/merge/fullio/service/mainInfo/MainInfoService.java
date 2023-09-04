package com.merge.fullio.service.mainInfo;

import com.merge.fullio.DTO.skill.SkillDTO;
import com.merge.fullio.DTO.strength.StrengthDTO;
import com.merge.fullio.DTO.user.UserDTO;
import com.merge.fullio.model.skill.Skill;
import com.merge.fullio.model.strength.Strength;
import com.merge.fullio.model.user.User;
import com.merge.fullio.repository.SkillRepository;
import com.merge.fullio.repository.StrengthRepository;
import com.merge.fullio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainInfoService {
    private final UserRepository userRepository;
    private final StrengthRepository strengthRepository;
    private final SkillRepository skillRepository;

    public UserDTO getUserInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        return new UserDTO(user1.getId(), user1.getUserNumber(), user1.getUsername(), user1.getNickName(), user1.getEmail(), user1.getPhoneNumber());
    }

    public StrengthDTO getStrengthInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        Optional<Strength> strengthOptional = strengthRepository.findByCreatedBy(user1);
        Strength strength = strengthOptional.get();
        return new StrengthDTO(strength.getId(), strength.getStrength_1(), strength.getStrength_2(), strength.getStrength_3(), strength.getStrength_4(), strength.getStrength_5(), strength.getMotto());
    }

    public SkillDTO getSkillInfo(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        Optional<Skill> skillOptional = skillRepository.findByCreatedBy(user1);
        Skill skill = skillOptional.get();
        return new SkillDTO(skill.getId(), skill.getSkill_1(), skill.getSkill_1_Percentage(), skill.getSkill_2(), skill.getSkill_2_Percentage(), skill.getSkill_3(), skill.getSkill_3_Percentage(), skill.getSkill_4(), skill.getSkill_4_Percentage());
    }
}
