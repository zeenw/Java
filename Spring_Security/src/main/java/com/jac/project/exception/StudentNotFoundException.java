package com.jac.project.exception;

public class StudentNotFoundException extends RuntimeException {
    private String message;

    public StudentNotFoundException(String message){
        super(message);
    }

}
