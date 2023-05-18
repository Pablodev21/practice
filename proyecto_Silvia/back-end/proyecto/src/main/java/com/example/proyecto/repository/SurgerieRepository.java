package com.example.proyecto.repository;

import com.example.proyecto.model.Surgerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurgerieRepository extends JpaRepository<Surgerie, Integer> {

    Optional<Surgerie> findById (int id);

    @Query(value = "SELECT * FROM surgeries WHERE idClient = (?1) ", nativeQuery = true)
    List<Surgerie> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM surgeries LIMIT 8 ", nativeQuery = true)
    List<Surgerie> get8Surgeries();

    @Query(value = "SELECT * FROM surgeries WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Surgerie> get8IdClient(int idClient);

    void deleteById(int id);
}
