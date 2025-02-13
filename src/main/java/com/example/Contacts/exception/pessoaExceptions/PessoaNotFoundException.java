package com.example.Contacts.exception.pessoaExceptions;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(String msg){
        super(msg);
    }
}
