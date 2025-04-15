package com.example.curriculosb.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nome;
    private String profissao;
    private String resumo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ExperienciaAcademica> formacoes = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ExperienciaProfissional> experiencias = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Habilidades> habilidades = new ArrayList<>();

    public Pessoa(Long id, String nome, String profissao, String resumo, List<Contato> contatos, List<ExperienciaAcademica> formacoes, List<ExperienciaProfissional> experiencias, List<Habilidades> habilidades) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.resumo = resumo;
        this.contatos = contatos;
        this.formacoes = formacoes;
        this.experiencias = experiencias;
        this.habilidades = habilidades;
    }

    public Pessoa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<ExperienciaAcademica> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<ExperienciaAcademica> formacoes) {
        this.formacoes = formacoes;
    }

    public List<ExperienciaProfissional> getExperiencias() {
        return experiencias;
    }


    public void setExperiencias(List<ExperienciaProfissional> experiencias) {
        this.experiencias = experiencias;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }
}
