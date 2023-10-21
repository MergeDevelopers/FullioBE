package com.merge.fullio.exception.clienterror._401;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;

public class NotLoginException extends UnauthorizedException {
    private BaseExceptionDto baseExceptionDto;

    public NotLoginException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public NotLoginException() {}

    public NotLoginException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
