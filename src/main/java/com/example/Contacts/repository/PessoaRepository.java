package com.example.Contacts.repository;


import com.example.Contacts.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    boolean existsByNome(String nome);
}
