package com.example.proyecto.repository;

import com.example.proyecto.model.Allergie;
import com.example.proyecto.model.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

    Optional<Evaluation> findById (int id);

    @Query(value = "SELECT * FROM evaluations WHERE idClient = (?1) ", nativeQuery = true)
    List<Evaluation> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM evaluations LIMIT 8 ", nativeQuery = true)
    List<Evaluation> get8Evaluations();

    @Query(value = "SELECT * FROM evaluations WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Evaluation> get8IdClient(int idClient);

    void deleteById(int id);




}
