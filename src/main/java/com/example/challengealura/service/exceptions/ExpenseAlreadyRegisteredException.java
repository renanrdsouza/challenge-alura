package com.example.challengealura.service.exceptions;

public class ExpenseAlreadyRegisteredException extends RuntimeException{

    public ExpenseAlreadyRegisteredException(String msg) {
        super(msg);
    }

    public ExpenseAlreadyRegisteredException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
