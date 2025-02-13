package com.example.Contacts.controller.exception;

import com.example.Contacts.controller.exception.model.StandardError;
import com.example.Contacts.exception.pessoaExceptions.PessoaAlreadyExistsException;
import com.example.Contacts.exception.pessoaExceptions.PessoaNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PessoaExceptionHandler {

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<StandardError> handlePessoaNotFound(PessoaNotFoundException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PessoaAlreadyExistsException.class)
    public ResponseEntity<StandardError> handlePessoaAlreadyExists(PessoaAlreadyExistsException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.CONFLICT.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
