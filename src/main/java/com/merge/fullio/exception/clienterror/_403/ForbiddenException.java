package com.merge.fullio.exception.clienterror._403;

import com.merge.fullio.exception.BaseExceptionDto;
import com.merge.fullio.exception.BaseResponseStatus;
import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException {

    private String key;

    private Long id;

    private Class domain;

    private BaseExceptionDto baseExceptionDto;

    public ForbiddenException(BaseResponseStatus baseResponseStatus){
        this.baseExceptionDto = BaseExceptionDto.builder()
                .error(baseResponseStatus.isError())
                .code(baseResponseStatus.getCode())
                .message(baseResponseStatus.getMessage())
                .build();
    }

    public ForbiddenException (String key, Long id ,Class domain) {
        super(String.format("key: %s, entity:%s not Found", key, domain.getName()));
        this.key = key;
        this.id = id;
        this.domain = domain;
    }

    public ForbiddenException (Long key, Long id ,Class domain) {
        super(String.format("key: %s, entity:%s not Found", key, domain.getName()));
        this.key = String.valueOf(key);
        this.id = id;
        this.domain = domain;
    }

    @Override
    public String getMessage() {
        return baseExceptionDto.getMessage();
    }
}
