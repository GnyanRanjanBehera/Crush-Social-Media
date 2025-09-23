package com.crush.crush_user_service.exceptions;

public class BadApiRequestException extends  RuntimeException{
    public BadApiRequestException(){super("Bad Request");}
    public BadApiRequestException(String message){ super(message);}
}
