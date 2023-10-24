package com.merge.fullio.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    /**
     * 요청 성공시 코드
     */
    SUCCESS(false, 200, "요청이 성공적으로 완료되었습니다."),
    GET_SUCCESS(false,200,"요청이 성공적으로 완료되었습니다"),
    CREATE_SUCCESS(false,201,"생성 요청이 성공적으로 완료되었습니다"),
    UPDATE_SUCCESS(false,204,"수정 요청이 성공적으로 완료되었습니다"),
    DELETE_SUCCESS(false,204,"삭제 요청이 성공적으로 완료되었습니다"),

    /**
     * 새로운 에러 코드
     */
    INVALID_USER(true, 1, "유저 정보가 맞지 않습니다."),
    EXIST_DATA(true,2,"이미 존재하는 데이터입니다."),
    NOT_FOUND_DATA(true,3,"존재하지 않는 데이터입니다."),
    EXIST_SUB_CATEGORY(true,4,"하위 카테고리가 있어서 삭제가 되지 않습니다"),

    /**
     * 이미 알려진 에러코드
     */
    BAD_REQUEST(true,400,"잘못된 요청입니다"),
    ENTITY_NOT_FOUND(true, 400, ""),
    EXIST_ENTITY(true, 400, ""),
    TOKEN_EXPIRED(true, 400, ""),
    NOT_LOGIN(true, 401, ""),
    UNAUTHORIZED(true, 401, ""),
    FORBIDDEN(true, 401, ""),
    ;

    private final boolean error;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean error, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.error = error;
        this.code = code;
        this.message = message;
    }
}
