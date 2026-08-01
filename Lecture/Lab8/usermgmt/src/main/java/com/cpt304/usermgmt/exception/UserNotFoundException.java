package com.cpt304.usermgmt.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String msg){
        super(msg);
    }    

    public UserNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }        
}
