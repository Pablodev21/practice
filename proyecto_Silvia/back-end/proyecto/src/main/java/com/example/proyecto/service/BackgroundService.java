package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;


import java.util.List;
import java.util.Optional;


public interface BackgroundService {

    Background saveBackground(Background background)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Background> findById(int Id);

    List<Background> findAllidClient(int idClient);

    List<Background> get8Backgrounds();

    List<Background> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyBackground (Background background, int id);
}
