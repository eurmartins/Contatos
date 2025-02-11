package com.example.Contacts.controller;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<PessoaEntity> adicionarPessoa(@RequestBody PessoaEntity pessoa){
        PessoaEntity novaPessoa = pessoaService.criarPessoa(pessoa);
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
    }

    @GetMapping("/procurarPorId/{id}")
    public ResponseEntity<PessoaEntity> procurarPessoaPorId(@PathVariable Long id) {
        return pessoaService.procurarPorId(id);
    }

    @GetMapping("/malaDireta/{id}")//ok
    public ResponseEntity<PessoaDTO> obterMalaDireta(@PathVariable Long id) {
        return pessoaService.obterMalaDireta(id);
    }

    @GetMapping("/listar")//ok
    public ResponseEntity<List<PessoaEntity>>listarPessoas(){
        List<PessoaEntity> people = pessoaService.listarPessoas();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")//ok
    public ResponseEntity<PessoaEntity> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/excluir/{id}") //ok
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        return pessoaService.excluirPessoa(id);
    }



}
