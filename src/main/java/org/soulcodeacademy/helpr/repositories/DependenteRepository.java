package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
}