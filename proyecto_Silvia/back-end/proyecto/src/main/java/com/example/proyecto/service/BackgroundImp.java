package com.example.proyecto.service;


import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.User;
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

        Optional<Background> backgroundFinded = repository.findById(background.getId());
        if(!backgroundFinded.isPresent()){
            return repository.save(background);
        }else{
            throw new ExceptionApp("Cant create the background");
        }
    }

    @Override
    public List<Background> findAllbyIdClient(int idClient) throws ExceptionApp {
        return null;
    }

    @Override
    @Transactional
    public Background modifyBackground(Background background) {
        return null;
    }

    @Override
    @Transactional
    public Background deleteBackground(Background background) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Background> findBackgroundToIdClient(int idClient) {

        return  repository.findByIdClient(idClient);
    }
}
