package com.micro.account.exception;

import java.io.Serial;

public class ResourceNotFoundException  extends  RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    ResourceNotFoundException(){
        super("Resource Not Found Exception");
    }
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
