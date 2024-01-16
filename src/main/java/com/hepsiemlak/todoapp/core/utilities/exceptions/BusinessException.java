package com.hepsiemlak.todoapp.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message); //Send message to base class
    }
}
