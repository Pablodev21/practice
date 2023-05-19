package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Observation;
import com.example.proyecto.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ObservationImp implements ObservationService{

    @Autowired
    private ObservationRepository repository;

    @Override
    public Observation saveObservation(Observation observation) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(observation);
    }

    @Override
    public Optional<Observation> findById(int Id) {
        return repository.findById(Id);
    }

    @Override
    public List<Observation> findAllidClient(int idClient) {
        return repository.findAllIdClient( idClient);
    }

    @Override
    public List<Observation> get8Observations() {
        return repository.get8Observation();
    }

    @Override
    public List<Observation> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void modifyObservation(Observation observation, int id) {
        Optional<Observation> observationChecked = this.repository.findById(id);

        Observation observationModify= observationChecked.get();
        observationModify.setId(observation.getId());
        observationModify.setIdClient(observation.getIdClient());
        observationModify.setName(observation.getName());
        observationModify.setDescription(observation.getDescription());
        observationModify.setDate(observation.getDate());
    }
}
