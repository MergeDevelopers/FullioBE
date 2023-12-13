package com.merge.fullio.controller.record;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.merge.fullio.exception.BaseResponse;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonPropertyOrder({"error", "code", "message"})
public class RecordsResponse<T> extends BaseResponse<T> {

    private T records;
    public RecordsResponse(T records, BaseResponseStatus baseResponseStatus) {
        super(baseResponseStatus);
        this.records = records;
    }

    public RecordsResponse(BaseResponseStatus baseResponseStatus){
        super(baseResponseStatus);
    }
}

