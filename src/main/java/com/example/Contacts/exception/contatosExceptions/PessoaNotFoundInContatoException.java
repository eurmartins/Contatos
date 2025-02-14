package com.example.Contacts.exception.contatosExceptions;

import com.example.Contacts.exception.pessoaExceptions.PessoaNotFoundException;

public class PessoaNotFoundInContatoException extends RuntimeException{
    public PessoaNotFoundInContatoException(String msg){
        super(msg);
    }
}
