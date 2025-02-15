package com.example.Contacts.exception.contatosExceptions;

public class ContatoNaoEncontradoException extends RuntimeException{
    public ContatoNaoEncontradoException(String msg){
        super(msg);
    }
}
