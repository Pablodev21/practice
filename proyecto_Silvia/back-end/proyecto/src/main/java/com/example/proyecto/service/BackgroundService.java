package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BackgroundService {

    Background saveBackground(Background background)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    void deleteBackground(Background background);

    Optional<Background> findById(int Id);

    List<Background> findAllidClient(int idClient);

    List<Background> get8Backgrounds();

    List<Background> get8IdClient(int idClient);

}
