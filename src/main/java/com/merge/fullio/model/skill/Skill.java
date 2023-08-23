package com.merge.fullio.model.skill;

import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String skill_1_Percentage;

    @Column
    private String skill_2;

    @Column
    private String skill_2_Percentage;

    @Column
    private String skill_3;

    @Column
    private String skill_3_Percentage;

    @Column
    private String skill_4;

    @Column
    private String skill_4_Percentage;


}
