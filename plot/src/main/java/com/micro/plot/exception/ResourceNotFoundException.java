package com.micro.plot.exception;
import java.io.Serial;
public class ResourceNotFoundException extends  RuntimeException {
    @Serial
    private  static  final long serialVersionUID=1L;
    ResourceNotFoundException(){
        super("ResourceNotFoundException");

    }
    public ResourceNotFoundException(String message){
        super(message);
    }

}
