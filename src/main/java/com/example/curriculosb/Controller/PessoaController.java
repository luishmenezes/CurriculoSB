package com.example.curriculosb.Controller;

import com.example.curriculosb.Model.*;
import com.example.curriculosb.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        if (pessoa.getContatos() != null) {
            for (Contato contato : pessoa.getContatos()) {
                contato.setPessoa(pessoa);
            }

        }

        if(pessoa.getFormacoes() == null) {
            for (ExperienciaAcademica experienciaAcademica : pessoa.getFormacoes()){
                experienciaAcademica.setPessoa(pessoa);
            }
        }

        if(pessoa.getExperiencias() == null) {
            for(ExperienciaProfissional experienciaProfissional : pessoa.getExperiencias()){
                experienciaProfissional.setPessoa(pessoa);
            }
        }

        if(pessoa.getHabilidades() == null) {
            for(Habilidades habilidades : pessoa.getHabilidades()){
                habilidades.setPessoa(pessoa);
            }
        }

        return pessoaRepository.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> deletarPorId(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
