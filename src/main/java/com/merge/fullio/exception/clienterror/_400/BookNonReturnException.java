package com.merge.fullio.exception.clienterror._400;

public class BookNonReturnException extends BadRequestException{

    public BookNonReturnException(Long id) {
        super(String.format("id:%d, BorrowInfo is Non Return", id));
    }

}
