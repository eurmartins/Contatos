package com.example.Contacts.entities;

import com.example.Contacts.enums.TipoContato;
import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoContato tipoContato;

    @Column(nullable = false)
    private String contato;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoaEntity pessoa;

    public ContatoEntity() {
    }

    public ContatoEntity(Long id, TipoContato tipoContato, String contato, PessoaEntity pessoa) {
        this.id = id;
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.pessoa = pessoa;
    }


    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }
}
