package com.merge.fullio.DTO.strength;

import com.merge.fullio.model.strength.Strength;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StrengthDTO {

    private long id;

    private int strength_1;

    private int strength_2;

    private int strength_3;

    private int strength_4;

    private int strength_5;

    public static StrengthDTO of (Strength strength){
        return new StrengthDTO(strength.getId(),strength.getStrength_1(), strength.getStrength_2(), strength.getStrength_3(), strength.getStrength_4(), strength.getStrength_5());
    }
}
