package com.example.Contacts.controller;
import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/criar")
    public ResponseEntity<ContatoDTO> adicionarContato(@RequestBody ContatoDTO contatoDTO) {
        ContatoDTO novoContato = contatoService.criarContato(contatoDTO);
        return new ResponseEntity<>(novoContato, HttpStatus.CREATED);
    }

    @GetMapping("/obterContatoPorId/{id}")
    public ResponseEntity<ContatoEntity> obterContatoPorId(@PathVariable Long id) {
        return contatoService.obterContatoPorId(id);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<ContatoDTO>> listarContatosPorPessoa(@PathVariable Long pessoaId) {
        return contatoService.listarContatosPorPessoa(pessoaId);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        return contatoService.atualizarContato(id, contatoDTO);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        return contatoService.deletarContato(id);
    }
}