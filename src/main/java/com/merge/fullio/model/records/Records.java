package com.merge.fullio.model.records;

import com.merge.fullio.DTO.record.RecordRequest;
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
public class Records extends WriterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @OneToMany
    private List<Comments> commentsList;

    public Records(RecordRequest recordRequest, Category category){
        this.title = recordRequest.getTitle();
        this.content = recordRequest.getContent();
        this.category = category;
    }

    public void updateRecords(RecordRequest recordRequest){
        this.title = recordRequest.getTitle();
        this.content = recordRequest.getContent();
    }

    public void addComment(Comments comments) {
        commentsList.add(comments);
    }

    public void changeCategory(Category category) {
        this.category = category;
    }
}
