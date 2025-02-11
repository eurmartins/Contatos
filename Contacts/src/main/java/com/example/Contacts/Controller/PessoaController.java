package com.example.Contacts.Controller;

import com.example.Contacts.dto.EnderecoTotal;
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
    public ResponseEntity<PessoaEntity> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoa){
        PessoaEntity pessoaAtt = pessoaService.atualizarPessoa(id, pessoa);
        if(pessoaAtt != null){
            return new ResponseEntity<>(pessoaAtt, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id){
        boolean foiDeletado = pessoaService.excluirPessoa(id);
        if(foiDeletado){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaEntity>>listarPessoas(){
        List<PessoaEntity> people = pessoaService.listarPessoas();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/enderecoTotal/{id}")
    public ResponseEntity<EnderecoTotal> obterEnderecoTotal(@PathVariable Long id) {
        Optional<EnderecoTotal> enderecoTotal = pessoaService.procurarEnderecoTotal(id);
        return enderecoTotal.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/procurarPorId/{id}")
    public ResponseEntity<Optional<PessoaEntity>> procurarPessoaPorId(@PathVariable Long id){
        Optional<PessoaEntity> pessoa = pessoaService.procurarPorId(id);
        if(pessoa != null){
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
