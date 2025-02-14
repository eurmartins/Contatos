package com.example.Contacts.controller.exception;

import com.example.Contacts.controller.exception.model.StandardError;
import com.example.Contacts.exception.contatosExceptions.ContatoNotFoundException;
import com.example.Contacts.exception.contatosExceptions.ContatoNotFoundToPessoaException;
import com.example.Contacts.exception.contatosExceptions.PessoaNotFoundInContatoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContatoExceptionHandler {

    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<StandardError> handleContatoNotFound(ContatoNotFoundException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PessoaNotFoundInContatoException.class)
    public ResponseEntity<StandardError> handlePessoaNotFoundInContatoException(PessoaNotFoundInContatoException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ContatoNotFoundToPessoaException.class)
    public ResponseEntity<StandardError> handleContatoNotFoundToPessoaException(ContatoNotFoundToPessoaException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
