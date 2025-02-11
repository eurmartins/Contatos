package com.example.Contacts.services;

import com.example.Contacts.dto.EnderecoTotal;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<EnderecoTotal> procurarEnderecoTotal(Long id) {
        return pessoaRepository.findById(id).map(EnderecoTotal::new);
    }

    public PessoaEntity criarPessoa(PessoaEntity pessoa){
        return pessoaRepository.save(pessoa);
    }

    public PessoaEntity atualizarPessoa(Long id, PessoaEntity pessoaAtt){
        Optional<PessoaEntity> existePessoa = pessoaRepository.findById(id);
        if(existePessoa.isPresent()){
            PessoaEntity pessoa = existePessoa.get();
            pessoa.setNome(pessoaAtt.getNome());
            pessoa.setEndereco(pessoaAtt.getEndereco());
            pessoa.setCep(pessoaAtt.getCep());
            pessoa.setCidade(pessoaAtt.getCidade());
            pessoa.setUf(pessoaAtt.getUf());
            return pessoaRepository.save(pessoa);
        }
        return null;
    }

    public Optional<PessoaEntity> procurarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public boolean excluirPessoa(Long id){
        if(pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
