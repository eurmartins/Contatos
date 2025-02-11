package com.example.Contacts.dto;

import com.example.Contacts.entities.PessoaEntity;

public record EnderecoTotal(Long id, String nome, String enderecoTotal) {
    public EnderecoTotal(PessoaEntity pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf()
        );
    }
}
