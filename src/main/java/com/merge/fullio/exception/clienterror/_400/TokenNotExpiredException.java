package com.merge.fullio.exception.clienterror._400;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;

public class TokenNotExpiredException extends BadRequestException {

    private BaseExceptionDto baseExceptionDto;

    public TokenNotExpiredException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public TokenNotExpiredException() {
        super("Access Token is Not Expire");
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
