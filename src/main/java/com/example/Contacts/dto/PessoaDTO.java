package com.example.Contacts.dto;

import com.example.Contacts.entities.PessoaEntity;

public record PessoaDTO(Long id, String nome, String malaDireta) {
    public PessoaDTO(PessoaEntity pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                String.format("%s - CEP: %s - %s/%s",
                        pessoa.getEndereco(),
                        pessoa.getCep(),
                        pessoa.getCidade(),
                        pessoa.getUf())
        );
    }
}
