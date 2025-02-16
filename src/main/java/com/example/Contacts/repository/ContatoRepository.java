package com.example.Contacts.repository;

import com.example.Contacts.entities.ContatoEntity;
import com.example.Contacts.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
    List<ContatoEntity> findByPessoaId(@Param("pessoaId") Long pessoaId);
}
