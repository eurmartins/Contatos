package com.example.Contacts.controller.exception.model;

public class ErroPadrao {

    private Integer status;
    private String mensagem;

    public ErroPadrao(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String message) {
        this.mensagem = mensagem;
    }

}
