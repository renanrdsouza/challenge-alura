package com.example.challengealura.controller.exceptions;

import com.example.challengealura.service.exceptions.IncomeAlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IncomeAlreadyRegisteredException.class)
    public ResponseEntity<StandardError> IncomeAlreadyRegistered(IncomeAlreadyRegisteredException e,
                                                                 HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }
}
