package com.example.proyecto.repository;

import com.example.proyecto.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {

    Optional<Treatment> findById (int id);

    @Query(value = "SELECT * FROM treatments WHERE idClient = (?1) ", nativeQuery = true)
    List<Treatment> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM treatments LIMIT 8 ", nativeQuery = true)
    List<Treatment> get8Treatments();

    @Query(value = "SELECT * FROM treatments WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Treatment> get8IdClient(int idClient);

    void deleteById(int id);
}
