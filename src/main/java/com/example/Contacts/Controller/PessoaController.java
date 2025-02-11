package com.example.Contacts.Controller;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<PessoaEntity> adicionarPessoa(@RequestBody PessoaEntity pessoa){
        PessoaEntity novaPessoa = pessoaService.criarPessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PessoaEntity> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa)
                .map(pessoaAtualizada -> new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        return pessoaService.excluirPessoa(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaEntity>>listarPessoas(){
        List<PessoaEntity> people = pessoaService.listarPessoas();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/enderecoTotal/{id}")
    public ResponseEntity<PessoaDTO> obterEnderecoTotal(@PathVariable Long id) {
        Optional<PessoaDTO> pessoaDTO = pessoaService.procurarEnderecoTotal(id);
        return pessoaDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/procurarPorId/{id}")
    public ResponseEntity<PessoaEntity> procurarPessoaPorId(@PathVariable Long id) {
        return pessoaService.procurarPorId(id);
    }

}
