package com.example.Contacts.Business;

import com.example.Contacts.Controller.DTO.PessoaDTO;
import com.example.Contacts.infrastructure.Entities.Pessoa;
import com.example.Contacts.infrastructure.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> getAllPessoas(){
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaDTO::new)
                .collect(Collectors.toList());
    }

    public Pessoa createPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa updatePessoa(Long id, Pessoa updatedpessoa){
        Optional<Pessoa> existPessoa = pessoaRepository.findById(id);
        if(existPessoa.isPresent()){
            Pessoa pessoa = existPessoa.get();
            pessoa.setNome(updatedpessoa.getNome());
            pessoa.setEndereco(updatedpessoa.getEndereco());
            pessoa.setCep(updatedpessoa.getCep());
            pessoa.setCidade(updatedpessoa.getCidade());
            pessoa.setUf(updatedpessoa.getUf());
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public boolean deletePessoa(Long id){
        if(pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
