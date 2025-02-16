package com.example.Contacts.controller.exception;

import com.example.Contacts.controller.exception.model.ErroPadrao;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoException;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoEmPessoaException;
import com.example.Contacts.exception.contatosExceptions.PessoaNaoEncontradaEmContatoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContatoExceptionHandler {

    @ExceptionHandler(ContatoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> handleContatoNaoEncontradoException(ContatoNaoEncontradoException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PessoaNaoEncontradaEmContatoException.class)
    public ResponseEntity<ErroPadrao> handlePessoaNaoEncontradaEmContatoException(PessoaNaoEncontradaEmContatoException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ContatoNaoEncontradoEmPessoaException.class)
    public ResponseEntity<ErroPadrao> handleContatoNaoEncontradoEmPessoaException(ContatoNaoEncontradoEmPessoaException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
