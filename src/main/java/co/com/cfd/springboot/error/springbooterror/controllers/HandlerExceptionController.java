package co.com.cfd.springboot.error.springbooterror.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.com.cfd.springboot.error.springbooterror.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setError("Error de división por cero!");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new Date());
        
        return ResponseEntity.internalServerError().body(error);
    }
}
