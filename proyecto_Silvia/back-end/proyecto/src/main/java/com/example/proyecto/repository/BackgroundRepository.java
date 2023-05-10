package com.example.proyecto.repository;

import com.example.proyecto.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BackgroundRepository extends JpaRepository<Background,Integer> {

    Optional<Background> findById (int id);
    /*
    @Query("SELECT b FROM backgrounds b WHERE idClient = :idClient")
    Optional<Background> findBackgroundByIdClient (@Param("idClient")int idClient);


     */
    /*
    @Query("SELECT b FROM backgrounds b WHERE b.client.id = :idClient")
    List<Background> findAllByClientId(@Param("idClient") int idClient);
    */

    @Query(value = "SELECT * FROM backgrounds WHERE idClient = (?1)", nativeQuery = true)
    List<Background> findAllIdClient(int idClient);


    // List<Background> findByIdClient (int idClient);

    /*
    @Query("UPDATE backgrounds b SET b.description = :valor1, b.date = :valor2 WHERE b.client.id = :idClient")
    void updateBackgroundByClientId (@Param("valor1") String valor1, @Param("valor2") String valor2, @Param("idClient") int idClient);
    */

}
