package com.example.Contacts.services;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaEntity> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional<PessoaDTO> procurarEnderecoTotal(Long id) {
        return pessoaRepository.findById(id).map(PessoaDTO::new);
    }

    public PessoaEntity criarPessoa(PessoaEntity pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Optional<PessoaEntity> atualizarPessoa(Long id, PessoaEntity pessoaAtt) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaAtt.getNome());
            pessoa.setEndereco(pessoaAtt.getEndereco());
            pessoa.setCep(pessoaAtt.getCep());
            pessoa.setCidade(pessoaAtt.getCidade());
            pessoa.setUf(pessoaAtt.getUf());
            return pessoaRepository.save(pessoa);
        });
    }

    public ResponseEntity<PessoaEntity> procurarPorId(Long id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Void> excluirPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
