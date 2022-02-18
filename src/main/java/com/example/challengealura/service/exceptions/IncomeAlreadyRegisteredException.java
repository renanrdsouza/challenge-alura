package com.example.challengealura.service.exceptions;

public class IncomeAlreadyRegisteredException extends RuntimeException{

    public IncomeAlreadyRegisteredException(String msg) {
        super(msg);
    }

    public IncomeAlreadyRegisteredException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
