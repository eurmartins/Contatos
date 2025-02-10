package com.example.Contacts.Controller.DTO;

import com.example.Contacts.infrastructure.Entities.Pessoa;

public record PessoaDTO(Long id, String nome, String fullEndereco) {
    public PessoaDTO(Pessoa pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                String.format("%s – CEP: %s – %s/%s",
                        pessoa.getEndereco(),
                        pessoa.getCep(),
                        pessoa.getCidade(),
                        pessoa.getUf()
                )
        );
    }
}
