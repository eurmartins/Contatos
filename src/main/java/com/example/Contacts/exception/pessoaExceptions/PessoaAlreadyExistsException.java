package com.example.Contacts.exception.pessoaExceptions;

public class PessoaAlreadyExistsException extends RuntimeException{
    public PessoaAlreadyExistsException(String msg) {
        super(msg);
    }
}
