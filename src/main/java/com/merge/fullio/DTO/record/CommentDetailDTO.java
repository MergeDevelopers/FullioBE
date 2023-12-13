package com.merge.fullio.DTO.record;

import com.merge.fullio.model.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDetailDTO {

    private Long id;

    private String comment;

    private String createdBy;

    @Builder
    public CommentDetailDTO(Long id, String comment, User createdBy){
        this.id = id;
        this.comment = comment;
        this.createdBy = createdBy.getName();
    }
}
