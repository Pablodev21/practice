package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Evaluation;
import com.example.proyecto.repository.EvaluationRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationImp implements EvaluationService {

    @Autowired
    EvaluationRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Evaluation saveEvaluation(Evaluation evaluation) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(evaluation);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Evaluation> findById(int Id) {
        return repository.findById(Id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evaluation> findAllidClient(int idClient) {
        return repository.findAllIdClient( idClient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evaluation> get8Evaluations() {
        return repository.get8Evaluations();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Evaluation> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void modifyEvaluation(Evaluation evaluation, int id) {

    }
}
