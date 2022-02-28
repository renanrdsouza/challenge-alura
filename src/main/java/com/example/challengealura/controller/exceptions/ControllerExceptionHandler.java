package com.example.challengealura.controller.exceptions;

import com.example.challengealura.service.exceptions.ExpenseAlreadyRegisteredException;
import com.example.challengealura.service.exceptions.IncomeAlreadyRegisteredException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> NoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ExpenseAlreadyRegisteredException.class)
    public ResponseEntity<StandardError> ExpenseAlreadyRegistered(ExpenseAlreadyRegisteredException e,
                                                                           HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> EntityNotFound(EntityNotFoundException e,
                                                        HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<StandardError> EmptyResultDataAccess(EmptyResultDataAccessException e,
                                                               HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
