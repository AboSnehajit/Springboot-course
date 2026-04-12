package com.codingshuttleweek2.spingbootwebtutorial.springbootwebtutorial.exception;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
