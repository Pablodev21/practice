package com.example.proyecto.repository;

import com.example.proyecto.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BackgroundRepository extends JpaRepository<Background,Integer> {

    Optional<Background> findById (int id);
    /*
    @Query(value = "SELECT * FROM backgrounds WHERE idClient= (?1)", nativeQuery = true)
    List<Background> findBackgroundsOfClient (int idClient);
    */


    List<Background> findByIdClient (int idClient);
}
