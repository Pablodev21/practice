package com.example.proyecto.repository;

import com.example.proyecto.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BackgroundRepository extends JpaRepository<Background,Integer> {

    List<Background> findAllbyIdClient();
}
