package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Consultation;
import com.example.proyecto.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationImp implements ConsultationService{



    @Autowired
    private ConsultationRepository repository;

    @Override
    public Consultation saveConsultation(Consultation consultation) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(consultation);
    }

    @Override
    public Optional<Consultation> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Consultation> findAllidClient(int idClient) {
        return repository.findAllIdClient(idClient);
    }

    @Override
    public List<Consultation> get8Consultations() {
        return repository.get8Consultations();
    }

    @Override
    public List<Consultation> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    public void deleteById(int id) {
    repository.deleteById(id);
    }

    @Override
    public void modifyConsultation(Consultation consultation, int id) {

        Optional<Consultation> consultationChecked = this.repository.findById(id);

        Consultation consultationModify= consultationChecked.get();
        consultationModify.setId(consultation.getId());
        consultationModify.setIdClient(consultation.getIdClient());
        consultationModify.setTitle(consultation.getTitle());
        consultationModify.setDescription(consultation.getDescription());
        consultationModify.setDate(consultation.getDate());
    }

    @Override
    public List<Consultation> getTodayConsultations(Date date) {
        return repository.getTodayConsultations(date);
    }

    @Override
    public List<Consultation> getTodayClientConsul(Date date, int idClient) {
        return repository.getTodayClientConsul(date,idClient);
    }
}
