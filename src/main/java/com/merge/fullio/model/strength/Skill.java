package com.merge.fullio.model.strength;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Skill {
    @Id
    private long strength_id; // PK로 사용

    @OneToOne
    @MapsId
    @JoinColumn(name = "strength_id")
    private Strength strength;

    @Column(columnDefinition = "TEXT")
    private String skills_1; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_2; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_3; // JSON 데이터를 문자열로 저장

    @Column(columnDefinition = "TEXT")
    private String skills_4; // JSON 데이터를 문자열로 저장

}
