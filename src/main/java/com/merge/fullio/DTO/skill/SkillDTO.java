package com.merge.fullio.DTO.skill;

import com.merge.fullio.model.skill.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    private long id;

    private String skill1;

    private String skill1P;

    private String skill2;

    private String skill2P;

    private String skill3;

    private String skill3P;

    private String skill4;

    private String skill4P;

    public static SkillDTO of (Skill skill){
        return new SkillDTO(skill.getId(), skill.getSkill_1(), skill.getSkill_1_Percentage(), skill.getSkill_2(), skill.getSkill_2_Percentage(), skill.getSkill_3(), skill.getSkill_3_Percentage(), skill.getSkill_4(), skill.getSkill_4_Percentage());
    }
}
