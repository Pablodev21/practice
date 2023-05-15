package com.example.proyecto.repository;

import com.example.proyecto.model.Allergie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AllergieRepository extends JpaRepository<Allergie, Integer> {

    Optional<Allergie> findById (int id);

    @Query(value = "SELECT * FROM allergies WHERE idClient = (?1) ", nativeQuery = true)
    List<Allergie> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM allergies LIMIT 8 ", nativeQuery = true)
    List<Allergie> get8Allergie();

    @Query(value = "SELECT * FROM allergies WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Allergie> get8IdClient(int idClient);

    void deleteById(int id);
}
