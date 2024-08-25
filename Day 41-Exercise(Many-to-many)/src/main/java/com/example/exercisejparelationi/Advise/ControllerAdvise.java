package com.example.exercisejparelationi.Advise;

import com.example.exercisejparelationi.API.APIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = APIException.class)
    public ResponseEntity handleAPIException(APIException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(e.getFieldError().getDefaultMessage());
    }
}
