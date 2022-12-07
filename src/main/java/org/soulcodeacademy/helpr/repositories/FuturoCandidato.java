package org.soulcodeacademy.helpr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuturoCandidato extends JpaRepository<FuturoCandidato, Integer> {

    List<FuturoCandidato> findByNome(String nome);

    List<FuturoCandidato> findByEmail(String email);

    List<FuturoCandidato> findBySetor(String setor);
}
