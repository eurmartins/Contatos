package com.example.Contacts.services;

import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.exception.contatosExceptions.ContatoNotFoundException;
import com.example.Contacts.repository.ContatoRepository;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoDTO criarContato(ContatoDTO contatoDTO) {
        PessoaEntity pessoa = pessoaRepository.findById(contatoDTO.pessoaId())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + contatoDTO.pessoaId()));
        ContatoEntity contato = new ContatoEntity();
        contato.setTipoContato(contatoDTO.tipoContato());
        contato.setContato(contatoDTO.contato());
        contato.setPessoa(pessoa);

        ContatoEntity contatoSalvo = contatoRepository.save(contato);
        return new ContatoDTO(contatoSalvo);
    }

    public ContatoEntity obterContatoPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado com ID: " + id));
    }

    public List<ContatoDTO> listarContatosPorPessoa(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId)
                .stream()
                .map(ContatoDTO::new)
                .toList();
    }

    public ContatoDTO atualizarContato(Long id, ContatoDTO contatoDTO) {
        ContatoEntity contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado com ID: " + id));

        contato.setTipoContato(contatoDTO.tipoContato());
        contato.setContato(contatoDTO.contato());
        ContatoEntity contatoAtualizado = contatoRepository.save(contato);
        return new ContatoDTO(contatoAtualizado);
    }

    public void deletarContato(Long id) {
       if(contatoRepository.existsById(id)){
           throw new ContatoNotFoundException("Contato não encontrado com ID: " + id);
       }
        contatoRepository.deleteById(id);
    }
}
