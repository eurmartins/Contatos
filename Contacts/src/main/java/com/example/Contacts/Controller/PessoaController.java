package com.example.Contacts.Controller;

import com.example.Contacts.Business.PessoaService;
import com.example.Contacts.Controller.DTO.PessoaDTO;
import com.example.Contacts.infrastructure.Entities.Pessoa;
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
    public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa pessoa){
        Pessoa novapessoa = pessoaService.createPessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa pessoaatt = pessoaService.updatePessoa(id, pessoa);
        if(pessoaatt != null){
            return new ResponseEntity<>(pessoaatt, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
        boolean isDelect = pessoaService.deletePessoa(id);
        if(isDelect){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaDTO>>listAllPessoa(){
        List<PessoaDTO> pessoas = pessoaService.getAllPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/procurarId/{id}")
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if(pessoa != null){
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
