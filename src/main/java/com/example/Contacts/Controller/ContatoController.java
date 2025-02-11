package com.example.Contacts.Controller;
import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;


    @PostMapping("/adicionar")
    public ResponseEntity<ContatoEntity> adicionarContato(@RequestBody ContatoDTO contatoDTO) {
        ContatoEntity contato = contatoService.criarContato(contatoDTO);
        return ResponseEntity.ok(contato);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContatoEntity> obterContatoPorId(@PathVariable Long id) {
        ContatoEntity contato = contatoService.obterContatoPorId(id);
        return ResponseEntity.ok(contato);
    }


    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<ContatoEntity>> listarContatosPorPessoa(@PathVariable Long pessoaId) {
        List<ContatoEntity> contatos = contatoService.listarContatosPorPessoa(pessoaId);
        return ResponseEntity.ok(contatos);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContatoEntity> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        ContatoEntity contatoAtualizado = contatoService.atualizarContato(id, contatoDTO);
        return ResponseEntity.ok(contatoAtualizado);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.noContent().build();
    }
}