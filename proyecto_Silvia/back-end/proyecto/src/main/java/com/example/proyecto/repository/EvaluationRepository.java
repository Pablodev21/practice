package com.example.proyecto.repository;

import com.example.proyecto.model.Evaluation;
import com.example.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EvaluationRepository extends JpaRepository<Integer, Evaluation> {
    Optional<Evaluation> findById(int id);

    /*
    @Query("SELECT * FROM evaluations WHERE idClient = (?1)" nativeQuery=true)
    List<Evaluation> findEvaluationsOfClient (int idClient);
    */




}
