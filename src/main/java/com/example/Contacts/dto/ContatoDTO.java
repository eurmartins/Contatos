package com.example.Contacts.dto;

import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.enums.TipoContato;

public record ContatoDTO(TipoContato tipoContato, String contato, Long pessoaId) {
    public ContatoDTO(ContatoEntity contatoEntity) {
        this(
                contatoEntity.getTipoContato(),
                contatoEntity.getContato(),
                contatoEntity.getPessoa().getId()
        );
    }
}