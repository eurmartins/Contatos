package com.example.Contacts.exception.contatosExceptions;

public class ContatoNotFoundException extends RuntimeException{
    public ContatoNotFoundException(String msg){
        super(msg);
    }
}
