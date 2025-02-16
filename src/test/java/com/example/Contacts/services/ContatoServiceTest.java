package com.example.Contacts.services;

import com.example.Contacts.dto.ContatoDTO;
import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
import com.example.Contacts.enums.TipoContato;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoEmPessoaException;
import com.example.Contacts.exception.contatosExceptions.ContatoNaoEncontradoException;
import com.example.Contacts.exception.contatosExceptions.PessoaNaoEncontradaEmContatoException;
import com.example.Contacts.repository.ContatoRepository;
import com.example.Contacts.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
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
class ContatoServiceTest {

    @Mock
    private ContatoRepository contatoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private ContatoService contatoService;


    private PessoaEntity pessoaTeste;
    private ContatoEntity contatoTeste;
    private ContatoDTO contatoDTOTeste;

    @BeforeEach
    void setup(){
        pessoaTeste = new PessoaEntity(1L, "Joao" , "Rua X", "9101910", "São Paulo", "SP");
        contatoTeste = new ContatoEntity(1L, TipoContato.TELEFONE, "999999999" , pessoaTeste);
        contatoDTOTeste = new ContatoDTO(contatoTeste);
    }

    @Test
    @DisplayName("Deve criar um contato atrelado a uma pessoa e retorna-lo com verificação de campos")
    void deveCriarContatoERetornarEle(){
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoaTeste));
        Mockito.when(contatoRepository.save(Mockito.any(ContatoEntity.class))).thenReturn(contatoTeste);

        ContatoDTO contatoResultado = contatoService.criarContato(contatoDTOTeste);
        assertNotNull(contatoResultado);
        assertEquals(TipoContato.TELEFONE, contatoResultado.tipoContato());
        assertEquals("999999999", contatoResultado.contato());
    }

    @Test
    @DisplayName("Deve procurar a Pessoa pelo Id e retornar a Exception PessoaNaoEncontradaEmContatoException")
    void deveProcurarPessoaPeloIdERetornarExceptionSeNaoEncontrar() {
        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(PessoaNaoEncontradaEmContatoException.class, () -> contatoService.criarContato(contatoDTOTeste));
    }

    @Test
    @DisplayName("Deve procurar uma entidade atrelada com esse Id e validar o campo equivalente a esse Id.")
    void deveProcurarOIdERetornarUmCampoEquivalente() {
        Mockito.when(contatoRepository.findById(1L)).thenReturn(Optional.of(contatoTeste));

        ContatoEntity contatoResultado = contatoService.obterContatoPorId(1L);
        assertNotNull(contatoResultado);
        assertEquals(TipoContato.TELEFONE,contatoResultado.getTipoContato());
    }

    @Test
    @DisplayName("Deve procurar um id que está vazio e retonar a Exception ContatoNaoEncontradoException")
    void deveProcurarOIdERetornarAException() {
        Mockito.when(contatoRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ContatoNaoEncontradoException.class, () -> contatoService.obterContatoPorId(1L));
    }

    @Test
    @DisplayName("Deve listar o contato atrelado a uma pessoa e retornar o tamanho dessa lista")
    void deveListarContatosDeUmaPessoa() {
        Mockito.when(contatoRepository.findByPessoaId(1L)).thenReturn(Collections.singletonList(contatoTeste));

        List<ContatoDTO> listaResultado = contatoService.listarContatosPorPessoa(1L);
        assertFalse(listaResultado.isEmpty());
        assertEquals(1, listaResultado.size());
    }


    @Test
    @DisplayName("Deve procurar contatos de uma pessoa e retornar a Exception ContatoNaoEncontradoEmPessoaException")
    void deveProcurarContatosDeUmaPessoaERetornarException() {
        Mockito.when(contatoRepository.findByPessoaId(1L)).thenReturn(Collections.emptyList());
        assertThrows(ContatoNaoEncontradoEmPessoaException.class, () -> contatoService.listarContatosPorPessoa(1L));
    }

    @Test
    @DisplayName("Deve deletar um contato pelo id")
    void deveDeletarUmContatoPorId() {
        Mockito.when(contatoRepository.existsById(1L)).thenReturn(true);
        contatoService.deletarContato(1L);
        Mockito.verify(contatoRepository, Mockito.times(1)).deleteById(1L);
    }

}