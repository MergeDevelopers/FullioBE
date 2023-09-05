package com.merge.fullio.exception.clienterror._400;

public class TokenNotExpiredException extends BadRequestException {

    public TokenNotExpiredException() {
        super("Access Token is Not Expire");
    }
}
