package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Treatment;
import java.util.List;
import java.util.Optional;

public interface TreatmentService {
    Treatment saveTreatment(Treatment treatment)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Treatment> findById(int Id);

    List<Treatment> findAllidClient(int idClient);

    List<Treatment> get8Treatments();

    List<Treatment> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyTreatment (Treatment treatment, int id);
}
