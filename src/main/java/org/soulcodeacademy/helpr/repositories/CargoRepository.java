package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    List<Cargo> findByNome(String valor);
    List<Cargo> findBySalario(Double valor);
    List<Cargo> findBySalarioGreaterThan(Double valor);
    List<Cargo> findBySalarioGreaterThanEqual(Double valor);
    List<Cargo> findBySalarioLessThan(Double valor);
    List<Cargo> findBySalarioLessThanEqual(Double valor);
    List<Cargo> findBySalarioBetween(Double valor1, Double valor2);
}