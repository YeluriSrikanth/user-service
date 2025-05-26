package com.user.userservice.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleException(NotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("ErrorMessage", ex.getMessage());
        return map;

    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> handleSuccess(NotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("SucessMessage", ex.getMessage());
        return map;

    }






}
