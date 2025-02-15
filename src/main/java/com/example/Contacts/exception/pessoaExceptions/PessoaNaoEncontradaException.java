package com.example.Contacts.exception.pessoaExceptions;

public class PessoaNaoEncontradaException extends RuntimeException{
    public PessoaNaoEncontradaException(String msg){
        super(msg);
    }
}
