package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Allergie;
import com.example.proyecto.model.Background;
import com.example.proyecto.repository.AllergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AllergieImp implements AllergieService{

    @Autowired
    private AllergieRepository repository;


    @Override
    public Allergie saveAllergie(Allergie allergie) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(allergie);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Allergie> findById(int Id) {
        return repository.findById(Id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Allergie> findAllidClient(int idClient) {
        return repository.findAllIdClient( idClient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Allergie> get8Allergies() {
        return repository.get8Allergie();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Allergie> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void modifyAllergie(Allergie allergie, int id) {
        Optional<Allergie> allergieChecked = this.repository.findById(id);

        Allergie allergieModified= allergieChecked.get();
        allergieModified.setId(allergie.getId());
        allergieModified.setIdClient(allergie.getIdClient());
        allergieModified.setName(allergie.getName());
        allergieModified.setDescription(allergie.getDescription());

    }
}
