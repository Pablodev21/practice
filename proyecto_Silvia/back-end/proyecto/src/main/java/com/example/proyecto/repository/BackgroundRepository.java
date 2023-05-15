package com.example.proyecto.repository;

import com.example.proyecto.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface BackgroundRepository extends JpaRepository<Background,Integer> {

    Optional<Background> findById (int id);

    @Query(value = "SELECT * FROM backgrounds WHERE idClient = (?1) ", nativeQuery = true)
    List<Background> findAllIdClient(int idClient);

    @Query(value="SELECT * FROM backgrounds LIMIT 8 ", nativeQuery = true)
    List<Background> get8Background();

    @Query(value = "SELECT * FROM backgrounds WHERE idClient = (?1) LIMIT 8", nativeQuery = true)
    List<Background> get8IdClient(int idClient);

    void deleteById(int id);
}
