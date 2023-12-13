package com.merge.fullio.DTO.record;

import com.merge.fullio.model.records.Comments;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class RecordsResDTO {

    private Long id;

    private Long categoryId;

    private String title;

    private String content;

    private List<CommentDetailDTO> commentDetailDTOList;

    private LocalDateTime createdAt;

    @Builder
    public RecordsResDTO (Long id, Long categoryId, String title, String content, List<Comments> commentsList, LocalDateTime createdAt) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.commentDetailDTOList = commentsList.stream().map(comments -> CommentDetailDTO.builder()
                .id(comments.getId())
                .comment(comments.getComment())
                .createdBy(comments.getCreatedBy())
                .build()).toList();
        this.createdAt = createdAt;
    }
}
