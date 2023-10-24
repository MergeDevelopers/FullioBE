package com.merge.fullio.exception.clienterror._400;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;

@Getter
public class ExistEntityException extends BadRequestException{

    private Object key;

    private BaseExceptionDto baseExceptionDto;

    public ExistEntityException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public ExistEntityException() {}

    public ExistEntityException (String key, Class domain) {
        super(String.format("key: %s, entity:%s is Exist", key, domain.getName()));
        this.key = key;
    }

    public ExistEntityException (Long key, Class domain) {
        super(String.format("key: %d, entity:%s is Exist", key, domain.getName()));
        this.key = key;
    }
}
