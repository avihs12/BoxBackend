package com.boxproject.backend.Exceptions;

public class UsernameAlreadyExistException extends Exception {

    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}