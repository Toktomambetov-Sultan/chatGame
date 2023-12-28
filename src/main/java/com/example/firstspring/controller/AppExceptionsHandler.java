package com.example.firstspring.controller;

import com.example.firstspring.expceptions.UserServiceExceptions;
import com.example.firstspring.model.response.ErrorMessage;
import com.example.firstspring.model.response.ErrorMessages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {
    @ExceptionHandler(value = {UserServiceExceptions.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceExceptions exceptions, WebRequest webRequest){
        ErrorMessage errorMessages = new ErrorMessage(new Date(),exceptions.getMessage());
        return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception exceptions, WebRequest webRequest){
        ErrorMessage errorMessages = new ErrorMessage(new Date(),exceptions.getMessage());
        return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
