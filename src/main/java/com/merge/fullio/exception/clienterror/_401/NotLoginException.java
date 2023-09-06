package com.merge.fullio.exception.clienterror._401;

public class NotLoginException extends UnauthorizedException {
    public NotLoginException() {}

    public NotLoginException(String message) {
        super(message);
    }
}
