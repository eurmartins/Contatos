package com.example.Contacts.exception.contatosExceptions;

public class PessoaNaoEncontradaEmContatoException extends RuntimeException{
    public PessoaNaoEncontradaEmContatoException(String msg){
        super(msg);
    }
}
