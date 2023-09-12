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
    private int skillNumber;

    @Column
    private String skillName;

    @Column
    private int skillValue;

    public Skill(SkillRequest skillRequest){
        this.skillNumber = skillRequest.getNumber();
        this.skillName = skillRequest.getSkillName();
        this.skillValue = skillRequest.getSkillValue();
    }

    public void setSkill(SkillRequest skillRequest){
        this.skillNumber = skillRequest.getNumber();
        this.skillName = skillRequest.getSkillName();
        this.skillValue = skillRequest.getSkillValue();
    }


}
