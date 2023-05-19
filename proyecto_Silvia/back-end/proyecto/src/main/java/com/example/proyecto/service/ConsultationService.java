package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Consultation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConsultationService {

    Consultation saveConsultation(Consultation consultation)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Consultation> findById(int id);

    List<Consultation> findAllidClient(int idClient);

    List<Consultation> get8Consultations();

    List<Consultation> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyConsultation (Consultation consultation, int id);

    List<Consultation> getTodayConsultations(Date date);

    List<Consultation>getTodayClientConsul(Date date, int idClient);
}
