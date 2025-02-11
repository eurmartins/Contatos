package com.example.Contacts.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContato {
    TELEFONE(0),
    CELULAR(1);

    private final int tipo;

    TipoContato(int tipo) {
        this.tipo = tipo;
    }

    @JsonValue
    public int getTipo() {
        return tipo;
    }

    @JsonCreator
    public static TipoContato Dispositivo(int tipo) {
        for (TipoContato dispositivo : TipoContato.values()) {
            if (dispositivo.getTipo() == tipo) {
                return dispositivo;
            }
        }
        throw new IllegalArgumentException("Código inválido para TypeContact: " + tipo);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
