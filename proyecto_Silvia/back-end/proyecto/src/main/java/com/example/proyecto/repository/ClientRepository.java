package com.example.proyecto.repository;

import com.example.proyecto.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client,Integer>{

    Optional<Client> findByNameIgnoreCase(String name);

    List<Client> findAll();

    @Query(value = "SELECT * FROM clients LIMIT 8", nativeQuery = true)
    List<Client> find8FirstClients();



}
