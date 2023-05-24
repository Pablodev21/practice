package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Allergie;

import java.util.List;
import java.util.Optional;

public interface AllergieService {

    Allergie saveAllergie(Allergie allergie)throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp;

    Optional<Allergie> findById(int Id);

    List<Allergie> findAllidClient(int idClient);

    List<Allergie> get8Allergies();

    List<Allergie> get8IdClient(int idClient);

    void deleteById(int id);

    void modifyAllergie (Allergie allergie, int id);
}
