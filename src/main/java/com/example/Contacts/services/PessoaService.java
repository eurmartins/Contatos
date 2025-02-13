package com.example.Contacts.services;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.exception.pessoaExceptions.PessoaAlreadyExistsException;
import com.example.Contacts.exception.pessoaExceptions.PessoaNotFoundException;
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
        if (pessoaRepository.existsByNome(pessoa.getNome())) {
            throw new PessoaAlreadyExistsException("Esse nome '" + pessoa.getNome() + "' já consta no sistema.");
        }
        return pessoaRepository.save(pessoa);
    }

    public PessoaEntity procurarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("O id " + id + " não consta no sistema"));
    }

    public PessoaDTO obterMalaDireta(Long id) {
        PessoaEntity pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("O id " + id + " não consta no sistema"));
        return new PessoaDTO(pessoa);
    }

    public List<PessoaEntity> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaEntity atualizarPessoa(Long id, PessoaEntity pessoaAtt) {
        PessoaEntity pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("O id " + id + " não consta no sistema."));

        pessoa.setNome(pessoaAtt.getNome());
        pessoa.setEndereco(pessoaAtt.getEndereco());
        pessoa.setCep(pessoaAtt.getCep());
        pessoa.setCidade(pessoaAtt.getCidade());
        pessoa.setUf(pessoaAtt.getUf());

        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new PessoaNotFoundException("O id " + id + " não consta no sistema.");
        }
        pessoaRepository.deleteById(id);
    }
}
