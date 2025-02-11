package com.example.Contacts.dto;

import com.example.Contacts.entities.PessoaEntity;

public record PessoaDTO(Long id, String nome, String malaDireta) {
    public PessoaDTO(PessoaEntity pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf()
        );
    }
}
