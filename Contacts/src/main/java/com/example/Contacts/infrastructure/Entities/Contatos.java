package com.example.Contacts.infrastructure.Entities;

import com.example.Contacts.infrastructure.Enums.TipoContato;
import jakarta.persistence.*;

@Entity
@Table(name = "contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TipoContato tipoContato;

    @Column(nullable = false)
    private String contato;

    public Contatos(){
    }

    public Contatos(Long id, TipoContato tipoContato, String contato){
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
