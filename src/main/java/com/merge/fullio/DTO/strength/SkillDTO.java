package com.merge.fullio.DTO.strength;

import com.merge.fullio.model.strength.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

    private List<String> skill_1;

    private List<String> skill_2;

    private List<String> skill_3;

    private List<String> skill_4;

    public SkillDTO(String skill_1, String skill_2, String skill_3, String skill_4){
        this.skill_1 = convertToList(skill_1);
        this.skill_2 = convertToList(skill_2);
        this.skill_3 = convertToList(skill_3);
        this.skill_4 = convertToList(skill_4);
    }
    private List<String> convertToList(String skills){
        List<String> convertList = List.of(skills.split("-"));
        return convertList;
    }

    public void setSkill_1(String skills){
        this.skill_1 = convertToList(skills);
    }

    public void setSkill_2(String skills){
        this.skill_2 = convertToList(skills);
    }

    public void setSkill_3(String skills){
        this.skill_3 = convertToList(skills);
    }

    public void setSkill_4(String skills){
        this.skill_4 = convertToList(skills);
    }
}
