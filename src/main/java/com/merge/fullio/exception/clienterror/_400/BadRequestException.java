package com.merge.fullio.exception.clienterror._400;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;

public class BadRequestException extends RuntimeException{

    private BaseExceptionDto baseExceptionDto;

    public BadRequestException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
