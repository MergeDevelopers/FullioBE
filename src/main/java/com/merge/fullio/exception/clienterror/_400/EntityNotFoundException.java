package com.merge.fullio.exception.clienterror._400;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;

@Getter
public class EntityNotFoundException extends BadRequestException {

    private Object key;

    private BaseExceptionDto baseExceptionDto;

    public EntityNotFoundException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public EntityNotFoundException () {}

    public EntityNotFoundException (String key, Class domain) {
        super(String.format("key: %s, entity:%s not Found", key, domain.getName()));
        this.key = key;
    }

    public EntityNotFoundException (Long key, Class domain) {
        super(String.format("key: %d, entity:%s not Found", key, domain.getName()));
        this.key = key;
    }
}
