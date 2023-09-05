package com.merge.fullio.model.strength;

import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Strength(int strength1, int strength2, int strength3, int strength4, int strength5){
        this.strength_1 = strength1;
        this.strength_2 = strength2;
        this.strength_3 = strength3;
        this.strength_4 = strength4;
        this.strength_5 = strength5;
        this.motto = null;
    }

    public Strength(String motto){
        this.motto = motto;
    }

//    public Strength(int number, List<String> skills){
//        switch (number) {
//            case 1 : this.skill_1 = skills;
//            case 2 : this.skill_2 = skills;
//            case 3 : this.skill_3 = skills;
//            case 4 : this.skill_4 = skills;
//        }
//    }


}
