package com.example.Contacts.infrastructure.Repository;

import com.example.Contacts.infrastructure.Entities.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {
}
