package com.merge.fullio.DTO.strength;

import com.merge.fullio.model.strength.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    private Map<String, List<String>> skills = new HashMap<>();

    public void addSkill(String skillNumber, List<String> skillData) {
        skills.put(skillNumber, skillData);
    }

}
