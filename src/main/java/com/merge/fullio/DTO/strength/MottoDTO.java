package com.merge.fullio.DTO.strength;

import com.merge.fullio.model.strength.Strength;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MottoDTO {

    private String motto;

    public static MottoDTO of(Strength strength){
        return new MottoDTO(strength.getMotto());
    }
}
