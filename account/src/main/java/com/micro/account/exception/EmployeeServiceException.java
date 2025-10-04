package com.micro.account.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;

public class EmployeeServiceException extends  RuntimeException{
    private final HttpStatus httpStatus;
    public  EmployeeServiceException(String message, HttpStatus httpStatus, FeignException e) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
