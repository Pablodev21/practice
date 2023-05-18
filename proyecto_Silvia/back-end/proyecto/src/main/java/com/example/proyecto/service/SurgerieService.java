package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Surgerie;

import java.util.List;
import java.util.Optional;

public interface SurgerieService {
    Surgerie saveSurgerie(Surgerie surgerie)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Surgerie> findById(int Id);

    List<Surgerie> findAllidClient(int idClient);

    List<Surgerie> get8Surgeries();

    List<Surgerie> get8IdClient(int idClient);

    void deleteById(int id);

    void modifySurgerie (Surgerie surgerie, int id);
}
