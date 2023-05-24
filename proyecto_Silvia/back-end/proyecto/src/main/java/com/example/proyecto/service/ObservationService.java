package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Observation;

import java.util.List;
import java.util.Optional;

public interface ObservationService {
    Observation saveObservation(Observation observation)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Observation> findById(int Id);

    List<Observation> findAllidClient(int idClient);

    List<Observation> get8Observations();

    List<Observation> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyObservation (Observation observation, int id);
}
