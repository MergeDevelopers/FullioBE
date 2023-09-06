package com.merge.fullio.model.strength;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private long id; // PK로 사용

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "strength_id")
//    private Strength strength;

    @Column(columnDefinition = "TEXT")
    private String skills_1; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_2; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_3; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_4; // JSON 데이터를 문자열로 저장



    /*public List<String> getSkillsDetail(String skillDetail) {
        if (skillDetail != null && !skillDetail.isEmpty()) {
            try {
                // JSON 문자열을 List<String>으로 역직렬화
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(skillDetail, new TypeReference<List<String>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // 빈 리스트 반환
    }*/

    public void setSkills_1(List<String> skills) {
        try {
            // List<String>을 JSON 문자열로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            skills_1 = objectMapper.writeValueAsString(skills);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setSkills_2(List<String> skills) {
        try {
            // List<String>을 JSON 문자열로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            skills_2 = objectMapper.writeValueAsString(skills);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setSkills_3(List<String> skills) {
        try {
            // List<String>을 JSON 문자열로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            skills_3 = objectMapper.writeValueAsString(skills);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setSkills_4(List<String> skills) {
        try {
            // List<String>을 JSON 문자열로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            skills_4 = objectMapper.writeValueAsString(skills);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public void setSKills(int number, List<String> skills){
        switch (number) {
            case 1 :
                setSkills_1(skills);
                break;
            case 2 :
                setSkills_2(skills);
                break;
            case 3 :
                setSkills_3(skills);
                break;
            case 4 :
                setSkills_4(skills);
                break;
        }
    }


}
