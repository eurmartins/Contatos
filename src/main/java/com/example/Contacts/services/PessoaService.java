package com.example.Contacts.services;

import com.example.Contacts.dto.PessoaDTO;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.exception.pessoaExceptions.PessoaJaExisteException;
import com.example.Contacts.exception.pessoaExceptions.PessoaNaoEncontradaException;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity criarPessoa(PessoaEntity pessoa){
        if (pessoaRepository.existsByNome(pessoa.getNome())) {
            throw new PessoaJaExisteException("Essa pessoa '" + pessoa.getNome() + "' já está registrada! Tente novamente!");
        }
        return pessoaRepository.save(pessoa);
    }

    public PessoaEntity procurarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException("O id " + id + " não está registrado! Tente novamente!"));
    }

    public PessoaDTO obterMalaDireta(Long id) {
        PessoaEntity pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException("O id " + id + " não está registrado! Tente novamente!"));
        return new PessoaDTO(pessoa);
    }

    public List<PessoaEntity> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaEntity atualizarPessoa(Long id, PessoaEntity pessoaAtt) {
        PessoaEntity pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException("O id " + id + " não está registrado! Tente novamente!"));

        pessoa.setNome(pessoaAtt.getNome());
        pessoa.setEndereco(pessoaAtt.getEndereco());
        pessoa.setCep(pessoaAtt.getCep());
        pessoa.setCidade(pessoaAtt.getCidade());
        pessoa.setUf(pessoaAtt.getUf());

        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new PessoaNaoEncontradaException("O id " + id + " não está registrado! Tente novamente!");
        }
        pessoaRepository.deleteById(id);
    }
}
