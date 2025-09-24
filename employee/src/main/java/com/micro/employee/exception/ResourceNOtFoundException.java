package com.micro.employee.exception;

public class ResourceNOtFoundException  extends  RuntimeException{
   private  static  final  long serialVersionUID=1L;
    ResourceNOtFoundException(){
        super("Resource Not Found Exception");

    }
    public ResourceNOtFoundException(String customMessage){
        super(customMessage);
    }
}
