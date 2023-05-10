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
    @Transactional(readOnly = true)
    public Optional <Background> findById(int Id) {
        return repository.findById(Id);

    }

    @Override
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
    public Background saveBackground(Background background) throws ExceptionApp {

        Optional<Background> backgroundFinded = repository.findById(background.getId());
        if(!backgroundFinded.isPresent()){
            return repository.save(background);
        }else{
            throw new ExceptionApp("Cant create the background");
        }
    }

    @Override
    @Transactional
    public void deleteBackground(Background background) {
         repository.delete(background);
    }


}
