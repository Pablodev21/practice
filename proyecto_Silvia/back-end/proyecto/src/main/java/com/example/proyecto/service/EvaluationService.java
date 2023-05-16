package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Allergie;
import com.example.proyecto.model.Evaluation;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {


    Evaluation saveEvaluation(Evaluation evaluation)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Evaluation> findById(int Id);

    List<Evaluation> findAllidClient(int idClient);

    List<Evaluation> get8Evaluations();

    List<Evaluation> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyEvaluation (Evaluation evaluation, int id);
}
