package com.example.curriculosb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ExperienciaAcademica {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instituicao;
    private String curso;
    private String nivel;
    private String anoTermino;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAnoTermino() {
        return anoTermino;
    }

    public void setAnoTermino(String anoTermino) {
        this.anoTermino = anoTermino;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }



    public ExperienciaAcademica(Long id, String instituicao, String curso, String nivel, String anoTermino, Pessoa pessoa) {
        this.id = id;
        this.instituicao = instituicao;
        this.curso = curso;
        this.nivel = nivel;
        this.anoTermino = anoTermino;
        this.pessoa = pessoa;
    }

    public ExperienciaAcademica() {}
}
