package com.merge.fullio.exception.clienterror._401;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;

public class UnauthorizedException extends RuntimeException {

    private BaseExceptionDto baseExceptionDto;

    public UnauthorizedException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }
    public UnauthorizedException() {}

    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
