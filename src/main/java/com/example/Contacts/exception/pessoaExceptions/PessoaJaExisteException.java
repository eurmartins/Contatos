package com.example.Contacts.exception.pessoaExceptions;

public class PessoaJaExisteException extends RuntimeException{
    public PessoaJaExisteException(String msg) {
        super(msg);
    }
}
