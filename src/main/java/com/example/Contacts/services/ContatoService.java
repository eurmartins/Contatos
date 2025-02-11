package com.example.Contacts.services;

import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
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

    public ContatoDTO criarContato(ContatoDTO contatoDTO) {//ok
        PessoaEntity pessoa = pessoaRepository.findById(contatoDTO.pessoaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Pessoa não encontrada com ID: " + contatoDTO.pessoaId()));
        ContatoEntity contato = new ContatoEntity();
        contato.setTipoContato(contatoDTO.tipoContato());
        contato.setContato(contatoDTO.contato());
        contato.setPessoa(pessoa);
        ContatoEntity contatoSalvo = contatoRepository.save(contato);
        return new ContatoDTO(contatoSalvo);
    }

    public ResponseEntity<ContatoEntity> obterContatoPorId(Long id) {//ok
        return contatoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ContatoDTO>> listarContatosPorPessoa(Long pessoaId) {
        List<ContatoDTO> contatos = contatoRepository.findByPessoaId(pessoaId)
                .stream()
                .map(ContatoDTO::new)
                .toList();
        return ResponseEntity.ok(contatos);
    }

    public ResponseEntity<ContatoDTO> atualizarContato(Long id, ContatoDTO contatoDTO) {//ok
        return contatoRepository.findById(id)
                .map(contato -> {
                    contato.setTipoContato(contatoDTO.tipoContato());
                    contato.setContato(contatoDTO.contato());
                    ContatoEntity contatoAtualizado = contatoRepository.save(contato);
                    return new ResponseEntity<>(new ContatoDTO(contatoAtualizado), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Void> deletarContato(Long id) {//ok
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
