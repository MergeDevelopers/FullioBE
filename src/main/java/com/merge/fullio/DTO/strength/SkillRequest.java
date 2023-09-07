package com.merge.fullio.DTO.strength;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {

    private List<String> skill_1;

    private List<String> skill_2;

    private List<String> skill_3;

    private List<String> skill_4;

}
