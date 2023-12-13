package com.merge.fullio.model.records;

import com.merge.fullio.model.WriterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Comments extends WriterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @JoinColumn(name = "records_id")
    @ManyToOne
    private Records records;

    public Comments(String comment, Records records) {
        this.comment = comment;
        this.records = records;
    }
}
