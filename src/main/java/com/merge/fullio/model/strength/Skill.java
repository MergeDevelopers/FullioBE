package com.merge.fullio.model.strength;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merge.fullio.DTO.strength.SkillRequest;
import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Skill extends WriterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String skill_1;

    @Column
    private String skill_2;

    @Column
    private String skill_3;

    @Column
    private String skill_4;

    public Skill(SkillRequest skillRequest){
        this.skill_1 = convertToString(skillRequest.getSkill_1());
        this.skill_2 = convertToString(skillRequest.getSkill_2());
        this.skill_3 = convertToString(skillRequest.getSkill_3());
        this.skill_4 = convertToString(skillRequest.getSkill_4());
    }
    public void setSkill(SkillRequest skillRequest){
        this.skill_1 = convertToString(skillRequest.getSkill_1());
        this.skill_2 = convertToString(skillRequest.getSkill_2());
        this.skill_3 = convertToString(skillRequest.getSkill_3());
        this.skill_4 = convertToString(skillRequest.getSkill_4());
    }

    private String convertToString(List<String> skills){
        StringBuilder sb = new StringBuilder();
        String buildSkills = String.valueOf(sb.append(skills.get(0)).append("-").append(skills.get(1)));
        return buildSkills;
    }



}
