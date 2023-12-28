package com.example.firstspring.expceptions;

public class UserServiceExceptions extends RuntimeException{
    public UserServiceExceptions(String message){
        super(message);
    }
}
