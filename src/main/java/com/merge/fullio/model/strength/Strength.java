package com.merge.fullio.model.strength;

import com.merge.fullio.DTO.strength.StrengthRequest;
import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Strength extends WriterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int strength_1;

    @Column
    private int strength_2;

    @Column
    private int strength_3;

    @Column
    private int strength_4;

    @Column
    private int strength_5;

    @Column
    private String motto;

    public Strength(StrengthRequest strengthRequest){
        this.strength_1 = strengthRequest.getStrength1();
        this.strength_2 = strengthRequest.getStrength2();
        this.strength_3 = strengthRequest.getStrength3();
        this.strength_4 = strengthRequest.getStrength4();
        this.strength_5 = strengthRequest.getStrength5();
        this.motto = null;
    }

    public Strength(String motto){
        this.motto = motto;
    }

    public void setStrength(StrengthRequest strengthRequest){
        this.strength_1 = strengthRequest.getStrength1();
        this.strength_2 = strengthRequest.getStrength2();
        this.strength_3 = strengthRequest.getStrength3();
        this.strength_4 = strengthRequest.getStrength4();
        this.strength_5 = strengthRequest.getStrength5();
    }

    public void setMotto(String motto){
        this.motto = motto;
    }


}
