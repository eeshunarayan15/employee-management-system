package com.micro.account.exception;

import java.io.Serial;

public class DublicateResourceException extends  RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    DublicateResourceException(){
        super("Resource Not Found Exception");
    }
    public DublicateResourceException(String message){
        super(message);
    }
}
