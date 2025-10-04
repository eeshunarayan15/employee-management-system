package com.micro.account.exception;

import com.micro.account.payload.ApiResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse<Object>> genericHanlder(Exception e){
        ApiResponse<Object> response = new ApiResponse<>("Error", "Something went wrong : "+e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidataionException(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();
//        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
//        for(FieldError fr : fieldError){
//            map.put(fr.getField(), fr.getDefaultMessage());
//        }
        exception.getBindingResult().getFieldErrors().forEach(error->map.put(error.getField(),error.getDefaultMessage()));
        ApiResponse<Map<String, String>> response = new ApiResponse<Map<String, String>>("Error", "Validation Error", map);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiResponse<Map<Object, Object>> response = new ApiResponse<>("Error", exception.getMessage(), Collections.emptyMap());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(DublicateResourceException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> handleDublicateResourceException(DublicateResourceException exception) {
        ApiResponse<Map<Object, Object>> response = new ApiResponse<>("Error", exception.getMessage(), Collections.emptyMap());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
//    @ExceptionHandler(FeignException.class)
//    public ResponseEntity<ApiResponse<Map<Object, Object>>> FeignExceptione(FeignException exception) {
//        String url = exception.request().url();
//        System.out.println(url);
//        String employeeId = url.substring(url.lastIndexOf("/") + 1);
//        System.out.println(employeeId);
//        HttpStatus httpStatus = HttpStatus.resolve(exception.status());
//        if(httpStatus==null){
//            HttpStatus internalServerError = httpStatus.INTERNAL_SERVER_ERROR;
//        }
//        String message;
//        if(httpStatus==HttpStatus.NOT_FOUND){
//            message="Employee not found with id"+employeeId;
//        }else {
//            message="Error while communicating with employee service "+employeeId;
//        }
//        ApiResponse<Map<Object, Object>> response = new ApiResponse<>("Error", message, Collections.emptyMap());
//        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//    }
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> EmployeeServiceExcepiton(EmployeeServiceException exception) {
        ApiResponse<Map<Object, Object>> response = new ApiResponse<>("Error", exception.getMessage(), Collections.emptyMap());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
