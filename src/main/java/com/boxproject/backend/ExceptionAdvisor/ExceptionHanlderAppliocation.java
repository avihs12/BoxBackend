package com.boxproject.backend.ExceptionAdvisor;

import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Exceptions.UsernameAlreadyExistException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHanlderAppliocation {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidInputsExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBusinessExceptions(ActivityNotFoundException ex) {
        Map<String, String> errormap = new HashMap<>();
        errormap.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(errormap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleBusinessExceptions(UsernameAlreadyExistException ex) {
        Map<String, String> errormap = new HashMap<>();
        errormap.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(errormap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
