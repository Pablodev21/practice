package com.example.proyecto.repository;

import com.example.proyecto.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

    Optional<Consultation> findById (int id);

    @Query(value = "SELECT * FROM consultations WHERE idClient = (?1)", nativeQuery = true)
    List<Consultation> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM consultations LIMIT 8 ", nativeQuery = true)
    List<Consultation> get8Consultations();

    @Query(value = "SELECT * FROM consultations WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Consultation> get8IdClient(int idClient);

    void deleteById(int id);

    @Query(value = "SELECT * FROM consultations WHERE date = (?1)", nativeQuery = true)
    List<Consultation> getTodayConsultations(Date date);

    @Query(value = "SELECT * FROM consultations WHERE date = (?1) and idClient = (?2)", nativeQuery = true)
    List<Consultation> getTodayClientConsul(Date date, int idClient);


}
