package com.example.Contacts.controller;
import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Adicionar Contato", description = "Cadastra um contato a uma pessoa já cadastrada no sistema.")
    public ResponseEntity<ContatoDTO> adicionarContato(@RequestBody ContatoDTO contatoDTO) {
        ContatoDTO novoContato = contatoService.criarContato(contatoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
    }

    @GetMapping("/obterContatoPorId/{id}")
    @Operation(summary = "Procurar Contato por Id", description = "Retorna um contato através de um Id cadastrado.")
    public ResponseEntity<ContatoEntity> obterContatoPorId(@PathVariable Long id) {
        ContatoEntity contato = contatoService.obterContatoPorId(id);
        return ResponseEntity.ok(contato);
    }

    @GetMapping("/pessoa/{pessoaId}")
    @Operation(summary = "Listar Contatos de uma Pessoa", description = "Retorna uma lista todos os contatos de uma pessoa cadastrada.")
    public ResponseEntity<List<ContatoDTO>> listarContatosPorPessoa(@PathVariable Long pessoaId) {
        List<ContatoDTO> contatos = contatoService.listarContatosPorPessoa(pessoaId);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar Contato", description = "Atualiza um contato por Id e retorna o contato atualizado.")
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO) {
        ContatoDTO contatoAtualizado = contatoService.atualizarContato(id, contatoDTO);
        return ResponseEntity.ok(contatoAtualizado);
    }

    @DeleteMapping("/excluir/{id}")
    @Operation(summary = "Deletar Contato", description = "Faz a busca pelo Id e exclui o contato cadastrado.")
    public ResponseEntity<Void> excluirContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.noContent().build();
    }
}