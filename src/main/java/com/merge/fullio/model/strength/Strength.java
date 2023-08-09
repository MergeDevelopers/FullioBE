package com.merge.fullio.model.strength;

import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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



}
