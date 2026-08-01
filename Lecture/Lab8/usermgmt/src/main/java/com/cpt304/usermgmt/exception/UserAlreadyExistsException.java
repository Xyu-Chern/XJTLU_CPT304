package com.cpt304.usermgmt.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super();
    }

    public UserAlreadyExistsException(String msg){
        super(msg);
    }

    public UserAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
