package com.merge.fullio.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.merge.fullio.exception.BaseResponseStatus.SUCCESS;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"error", "code", "message"})
public class BaseResponse<T> {

    @JsonProperty("error")
    private final Boolean error;
    private final String message;
    private final int code;

    // 기본 요청에 성공한 경우
    public BaseResponse() {
        this.error = SUCCESS.isError();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
    }

    public BaseResponse(T result) {
        this.error = SUCCESS.isError();
        this.message = SUCCESS.getMessage();
        this.code = SUCCESS.getCode();
    }

    // 성공 메세지를 보내는 경우
    public BaseResponse(String message) {
        this.error = SUCCESS.isError();
        this.message = message;
        this.code = SUCCESS.getCode();
    }

    // 기본 요청에 실패한 경우
    public BaseResponse(BaseResponseStatus status) {
        this.error = status.isError();
        this.message = status.getMessage();
        this.code = status.getCode();
    }
}
