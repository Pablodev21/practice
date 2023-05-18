package com.example.proyecto.repository;

import com.example.proyecto.model.Background;
import com.example.proyecto.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ObservationRepository extends JpaRepository<Observation,Integer> {

    Optional<Observation> findById (int id);

    @Query(value = "SELECT * FROM observations WHERE idClient = (?1) ", nativeQuery = true)
    List<Observation> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM observations LIMIT 8 ", nativeQuery = true)
    List<Observation> get8Observation();

    @Query(value = "SELECT * FROM backgrounds WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Observation> get8IdClient(int idClient);

    void deleteById(int id);
}
