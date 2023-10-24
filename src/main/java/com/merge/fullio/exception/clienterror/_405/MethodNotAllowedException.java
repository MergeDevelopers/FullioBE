package com.merge.fullio.exception.clienterror._405;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;

@Getter
public class MethodNotAllowedException extends RuntimeException {

    private BaseExceptionDto baseExceptionDto;

    public MethodNotAllowedException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
