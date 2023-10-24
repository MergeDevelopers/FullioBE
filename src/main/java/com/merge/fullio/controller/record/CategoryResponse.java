package com.merge.fullio.controller.record;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.merge.fullio.exception.BaseResponse;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonPropertyOrder({"error", "code", "message"})
public class CategoryResponse<T> extends BaseResponse<T> {

    private T category;
    public CategoryResponse(T category, BaseResponseStatus baseResponseStatus) {
        super(baseResponseStatus);
        this.category = category;
    }

    public CategoryResponse(BaseResponseStatus baseResponseStatus){
        super(baseResponseStatus);
    }
}
