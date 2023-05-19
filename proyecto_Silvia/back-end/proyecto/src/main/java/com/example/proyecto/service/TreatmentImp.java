package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Treatment;
import com.example.proyecto.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentImp implements TreatmentService{


    @Autowired
    private TreatmentRepository repository;

    @Override
    public Treatment saveTreatment(Treatment treatment) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(treatment);
    }

    @Override
    public Optional<Treatment> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Treatment> findAllidClient(int idClient) {
        return repository.findAllIdClient(idClient);
    }

    @Override
    public List<Treatment> get8Treatments() {
        return repository.get8Treatments();
    }

    @Override
    public List<Treatment> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    public void deleteById(int id) {
    repository.deleteById(id);
    }

    @Override
    public void modifyTreatment(Treatment treatment, int id) {
        Optional<Treatment> treatmentChecked = this.repository.findById(id);

        Treatment treatmentModify= treatmentChecked.get();
        treatmentModify.setId(treatment.getId());
        treatmentModify.setIdClient(treatment.getIdClient());
        treatmentModify.setName(treatment.getName());
        treatmentModify.setDescription(treatment.getDescription());
        treatmentModify.setDate(treatment.getDate());
    }
}
