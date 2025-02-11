package com.example.Contacts.services;

import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.repository.ContatoRepository;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<ContatoEntity> listarContatosPorPessoa(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId);
    }

    public ContatoEntity obterContatoPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
    }

    public ContatoEntity criarContato(ContatoDTO contatoDTO) {
        Optional<PessoaEntity> pessoa = pessoaRepository.findById(contatoDTO.getPessoaId());

        if (pessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Pessoa não encontrada com ID: " + contatoDTO.getPessoaId());
        }

        ContatoEntity contato = new ContatoEntity();
        contato.setTipoContato(contatoDTO.getTipoContato());
        contato.setContato(contatoDTO.getContato());
        contato.setPessoa(pessoa.get());

        return contatoRepository.save(contato);
    }

    public ContatoEntity atualizarContato(Long id, ContatoDTO contatoDTO) {
        ContatoEntity contatoExistente = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
        contatoExistente.setTipoContato(contatoDTO.getTipoContato());
        contatoExistente.setContato(contatoDTO.getContato());
        return contatoRepository.save(contatoExistente);
    }

    public void deletarContato(Long id) {
        ContatoEntity contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado com ID: " + id));
        contatoRepository.delete(contato);
    }
}