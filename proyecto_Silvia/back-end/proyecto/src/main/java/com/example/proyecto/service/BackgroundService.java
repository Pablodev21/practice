package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BackgroundService {

    Background saveBackground(Background background)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    List<Background> findAllbyIdClient(int idClient) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Background deleteBackground(Background background);

    Optional<Background> findById(int Id);

    Optional<Background> findBackgroundByIdClient(Background background);

    List<Background> findAllByClientId(int idClient);

    Background modifyBackgroundByClientId ( Background background);
}
