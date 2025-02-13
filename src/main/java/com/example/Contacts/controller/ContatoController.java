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
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
    }

    @GetMapping("/obterContatoPorId/{id}")
    public ResponseEntity<ContatoEntity> obterContatoPorId(@PathVariable Long id) {
        ContatoEntity contato = contatoService.obterContatoPorId(id);
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<ContatoDTO>> listarContatosPorPessoa(@PathVariable Long pessoaId) {
        List<ContatoDTO> contatos = contatoService.listarContatosPorPessoa(pessoaId);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        ContatoDTO contatoAtualizado = contatoService.atualizarContato(id, contatoDTO);
        return ResponseEntity.ok(contatoAtualizado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.noContent().build();
    }
}