package com.example.Contacts.services;

import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.exception.pessoaExceptions.PessoaJaExisteException;
import com.example.Contacts.exception.pessoaExceptions.PessoaNaoEncontradaException;
import com.example.Contacts.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    @DisplayName("Deve retornar uma Lista com uma Pessoa de tamanho 1.")
    void deveRetornarUmaListaDePessoas() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Victor", "Rua Tal" , "23131321", "Sao Paulo","Sp" );
        Mockito.when(pessoaRepository.findAll()).thenReturn(Collections.singletonList(new PessoaEntity()));
        List<PessoaEntity> pessoas = pessoaService.listarPessoas();
        Assertions.assertEquals(1, pessoas.size());
    }

    @Test
    @DisplayName("Deve criar uma pessoa e retornar o nome da pessoa cadastrada")
    void deveCriarUmaPessoaERetornarONome() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Victor", "paulista", "12122122", "Sao Paulo", "Sp");
        Mockito.when(pessoaRepository.existsByNome("Victor")).thenReturn(false);
        Mockito.when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        PessoaEntity pessoaRegistrada = pessoaService.criarPessoa(pessoa);
        Assertions.assertNotNull(pessoaRegistrada);
        Assertions.assertEquals("Victor", pessoaRegistrada.getNome());
    }

    @Test
    @DisplayName("Deve criar uma Pessoa que ja existe e Retornar a Exception PessoaJaExisteException")
    void deveCriarUmaPessoaQueJaExisteERetornarAException() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Patricia", "masp", "12445544", "Sao Paulo", "Sp");
        Mockito.when(pessoaRepository.existsByNome("Patricia")).thenReturn(true);
        Assertions.assertThrows(PessoaJaExisteException.class, () -> pessoaService.criarPessoa(pessoa));
    }

    @Test
    @DisplayName("Deve procurar o Id e retornar a entidade encontrada pelo Id. Tem a comparação de id e Nome.")
    void deveRetornarPessoaQuandoEncontradoPorId() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Joao", "farol", "1453541", "Sao Paulo", "Sp");
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        PessoaEntity pessoaEncontrada = pessoaService.procurarPorId(1L);

        Assertions.assertNotNull(pessoaEncontrada);
        Assertions.assertEquals(1L, pessoaEncontrada.getId());
        Assertions.assertEquals("Joao", pessoaEncontrada.getNome());
    }

    @Test
    @DisplayName("Deve procurar o Id que está vazio e retornar a Exception PessoaNaoEncontradaException")
    void deveProcurarUmIdVazioERetornarException() {
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(PessoaNaoEncontradaException.class, () -> pessoaService.procurarPorId(1L));
    }

    @Test
    @DisplayName("Deve Receber um Cadastro e outro atualizado, atualizar pelo Id passado e retornar o atualizado")
    void deveAtualizarAPessoaPeloId() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Naldo", "usp", "23131321", "Sao Paulo", "Sp");
        PessoaEntity pessoaAtt = new PessoaEntity(1L, "Naldo naldo", "sup", "99999999", "São Paulo", "SP");
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        Mockito.when(pessoaRepository.save(pessoa)).thenReturn(pessoaAtt);

        PessoaEntity pessoaRetorno = pessoaService.atualizarPessoa(1L, pessoaAtt);

        Assertions.assertEquals("Naldo naldo", pessoaRetorno.getNome());
        Assertions.assertEquals("sup", pessoaRetorno.getEndereco());
    }

    @Test
    @DisplayName("Deve receber uma Pessoa e ver se ela está cadastrada e logo após excluí-la pelo Id")
    void deveExcluirUmaPessoaCadastradaPeloId() {
        PessoaEntity pessoa = new PessoaEntity(1L, "Naldo", "usp", "23131321", "Sao Paulo", "Sp");
        Mockito.when(pessoaRepository.existsById(1L)).thenReturn(true);
        pessoaService.excluirPessoa(1L);
        Mockito.verify(pessoaRepository, Mockito.times(1)).deleteById(1L);
    }



}