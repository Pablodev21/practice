package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Surgerie;
import com.example.proyecto.repository.BackgroundRepository;
import com.example.proyecto.repository.SurgerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SurgerieImp implements SurgerieService {
    @Autowired
    private SurgerieRepository repository;


    @Override
    public Surgerie saveSurgerie(Surgerie surgerie) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {
        return repository.save(surgerie);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Surgerie> findById(int Id) {
        return repository.findById(Id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Surgerie> findAllidClient(int idClient) {
        return repository.findAllIdClient( idClient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Surgerie> get8Surgeries() {
        return repository.get8Surgeries();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Surgerie> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void modifySurgerie(Surgerie surgerie, int id) {
        Optional<Surgerie> surgerieChecked = this.repository.findById(id);

        Surgerie surgerieModify= surgerieChecked.get();
        surgerieModify.setId(surgerie.getId());
        surgerieModify.setIdClient(surgerie.getIdClient());
        surgerieModify.setName(surgerie.getName());
        surgerieModify.setDescription(surgerie.getDescription());
        surgerieModify.setDate(surgerie.getDate());
    }
}
