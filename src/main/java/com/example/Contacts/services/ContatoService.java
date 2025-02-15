package com.example.Contacts.services;

import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoException;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoEmPessoaException;
import com.example.Contacts.exception.contatosExceptions.PessoaNaoEncontradaEmContatoException;
import com.example.Contacts.repository.ContatoRepository;
import com.example.Contacts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public ContatoDTO criarContato(ContatoDTO contatoDTO) {
        PessoaEntity pessoa = pessoaRepository.findById(contatoDTO.pessoaId())
                .orElseThrow(() -> new PessoaNaoEncontradaEmContatoException("Pessoa não encontrada com ID: " + contatoDTO.pessoaId()));
        ContatoEntity contato = new ContatoEntity();
        contato.setTipoContato(contatoDTO.tipoContato());
        contato.setContato(contatoDTO.contato());
        contato.setPessoa(pessoa);

        ContatoEntity contatoSalvo = contatoRepository.save(contato);
        return new ContatoDTO(contatoSalvo);
    }

    public ContatoEntity obterContatoPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado com ID: " + id));
    }

    public List<ContatoDTO> listarContatosPorPessoa(Long pessoaId) {
        List<ContatoDTO> contatos = contatoRepository.findByPessoaId(pessoaId)
                .stream()
                .map(ContatoDTO::new)
                .toList();
        if (contatos.isEmpty()) {
            throw new ContatoNaoEncontradoEmPessoaException("Nenhum contato encontrado para a pessoa com ID: " + pessoaId);
        }
        return contatos;
    }


    public ContatoDTO atualizarContato(Long id, ContatoDTO contatoDTO) {
        ContatoEntity contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado com ID: " + id));

        contato.setTipoContato(contatoDTO.tipoContato());
        contato.setContato(contatoDTO.contato());
        ContatoEntity contatoAtualizado = contatoRepository.save(contato);
        return new ContatoDTO(contatoAtualizado);
    }

    public void deletarContato(Long id) {
        if (!contatoRepository.existsById(id)){
            throw new ContatoNaoEncontradoException("Contato não encontrado com ID: " + id);
        }
        contatoRepository.deleteById(id);
    }
}
