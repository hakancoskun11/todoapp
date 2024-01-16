package com.hepsiemlak.todoapp.core.utilities.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message); //Send message to base class
    }
}
