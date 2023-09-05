package com.merge.fullio.DTO.strength;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {

    private int number;

    private List<String> skill;

}
