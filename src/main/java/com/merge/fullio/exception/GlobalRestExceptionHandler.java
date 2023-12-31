package com.merge.fullio.exception;

import com.merge.fullio.exception.clienterror._400.BadRequestException;
import com.merge.fullio.exception.clienterror._401.UnauthorizedException;
import com.merge.fullio.exception.clienterror._403.ForbiddenException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RestControllerAdvice(annotations = RestController.class)
public class GlobalRestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleEntityNotFound(EntityNotFoundException ex) {
        return new ResponseError<String> (ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseError<String> (ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<List<String>> handleValidException(MethodArgumentNotValidException ex) {
        ArrayList<String> messageList = new ArrayList<>();
        try {
            for (ObjectError message : ex.getBindingResult().getAllErrors()) {
                messageList.add(message.getDefaultMessage());
            }
        }catch (Exception e) {
           messageList.add("요청이 옳지 않습니다.");
        }

        return new ResponseError<List<String>>(messageList);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleBadRequest(BadRequestException ex) {
        return new ResponseError<String> (ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleUnAuthorized(UnauthorizedException ex) {
        return new ResponseError<String> (ex.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleForbidden(ForbiddenException ex) {
        return new ResponseError<String> (ex.getMessage());
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseError<String> handleMethodNotAllowed(MethodNotAllowedException ex) {
        return new ResponseError<>(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseError<String> handleException(Exception ex) {
        return new ResponseError<String> (ex.getMessage());
    }
}
