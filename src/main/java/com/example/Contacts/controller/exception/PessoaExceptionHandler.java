package com.example.Contacts.controller.exception;

import com.example.Contacts.controller.exception.model.ErroPadrao;
import com.example.Contacts.exception.pessoaExceptions.PessoaJaExisteException;
import com.example.Contacts.exception.pessoaExceptions.PessoaNaoEncontradaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PessoaExceptionHandler {

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<ErroPadrao> handlePessoaNaoEncontrada(PessoaNaoEncontradaException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(PessoaJaExisteException.class)
    public ResponseEntity<ErroPadrao> handlePessoaJaExiste(PessoaJaExisteException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.CONFLICT.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroPadrao> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        ErroPadrao err = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
