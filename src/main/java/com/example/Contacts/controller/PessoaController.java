package com.example.Contacts.controller;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Cadastrar Pessoa", description = "Registra uma pessoa e retorna a pessoa cadastrada.")
    public ResponseEntity<PessoaEntity> salvarPessoa(@RequestBody PessoaEntity pessoa){
        PessoaEntity novaPessoa = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @GetMapping("/procurarPorId/{id}")
    @Operation(summary = "Procurar Pessoa pro Id", description = "Retorna a pessoa cadastradada através do Id informado.")
    public ResponseEntity<PessoaEntity> procurarPessoaPorId(@PathVariable Long id) {
        PessoaEntity pessoa = pessoaService.procurarPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/malaDireta/{id}")
    @Operation(summary = "Procurar MalaDireta", description = "Retorna uma pessoa cadastrada através do Id informado, porém com o Endereço formatado.")
    public ResponseEntity<PessoaDTO> obterMalaDireta(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaService.obterMalaDireta(id);
        return ResponseEntity.ok(pessoaDTO);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todas as Pessoas", description = "Retorna uma lista de todas as pessoas registradas.")
    public ResponseEntity<List<PessoaEntity>> listarPessoas(){
        List<PessoaEntity> people = pessoaService.listarPessoas();
        return ResponseEntity.ok(people);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar Pessoa", description = "Atualiza uma pessoa através do Id informado e retorna a pessoa atualizada.")
    public ResponseEntity<PessoaEntity> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoa) {
        PessoaEntity pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/excluir/{id}")
    @Operation(summary = "Excluir Pessoa", description = "Exclui a pessoa cadastrada através do Id informado.")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
