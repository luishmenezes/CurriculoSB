package com.example.curriculosb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity

public class Contato {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String valor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pessoa_id")
    public Pessoa pessoa;

    public Contato(String valor, String tipo, Long id) {
        this.valor = valor;
        this.tipo = tipo;
        this.id = id;
    }

    public Contato() {}

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
