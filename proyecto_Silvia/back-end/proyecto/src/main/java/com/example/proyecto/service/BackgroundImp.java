package com.example.proyecto.service;


import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.repository.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BackgroundImp implements BackgroundService{

    @Autowired
    private BackgroundRepository repository;

    @Override
    @Transactional
    public Background saveBackground(Background background) throws ExceptionApp {
        return repository.save(background);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional <Background> findById(int Id) {
        return repository.findById(Id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Background> findAllidClient(int idClient) {
        return repository.findAllIdClient( idClient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Background> get8Backgrounds() {
        return repository.get8Background();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Background> get8IdClient(int idClient) {
        return repository.get8IdClient(idClient);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void modifyBackground(Background background, int id) {
        Optional<Background> backgroundChecked = this.repository.findById(id);

           Background backgroundModify= backgroundChecked.get();
           backgroundModify.setId(background.getId());
           backgroundModify.setIdClient(background.getIdClient());
           backgroundModify.setName(background.getName());
           backgroundModify.setDescription(background.getDescription());
           backgroundModify.setDate(background.getDate());

           this.repository.save(backgroundModify);
    }

}
