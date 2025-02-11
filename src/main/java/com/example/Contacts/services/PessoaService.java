package com.example.Contacts.services;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity criarPessoa(PessoaEntity pessoa){
        return pessoaRepository.save(pessoa);
    }

    public ResponseEntity<PessoaEntity> procurarPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<PessoaDTO> obterMalaDireta(Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> new ResponseEntity<>(new PessoaDTO(pessoa), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public List<PessoaEntity> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public ResponseEntity<PessoaEntity> atualizarPessoa(Long id, PessoaEntity pessoaAtt) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(pessoaAtt.getNome());
                    pessoa.setEndereco(pessoaAtt.getEndereco());
                    pessoa.setCep(pessoaAtt.getCep());
                    pessoa.setCidade(pessoaAtt.getCidade());
                    pessoa.setUf(pessoaAtt.getUf());
                    PessoaEntity pessoaAtualizada = pessoaRepository.save(pessoa);
                    return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Void> excluirPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
