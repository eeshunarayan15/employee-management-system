package com.micro.employee.exception;

import com.micro.employee.payload.ApiResponse;
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
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> genericException(Exception exception) {
        ApiResponse<Object> res = new ApiResponse<>("Error", exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidataionException(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();
//        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
//        for(FieldError fr : fieldError){
//            map.put(fr.getField(), fr.getDefaultMessage());
//        }
        exception.getBindingResult().getFieldErrors().forEach(error->map.put(error.getField(),error.getDefaultMessage()));
        ApiResponse<Map<String, String>> response = new ApiResponse<>("Error", "Validation Error", map);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(ResourceNOtFoundException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> handleResourceNotFoundException(ResourceNOtFoundException exception) {
        ApiResponse<Map<Object, Object>> response = new ApiResponse<>("Error", exception.getMessage(), Collections.emptyMap());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
