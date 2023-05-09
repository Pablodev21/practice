package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;

import java.util.List;


public interface BackgroundService {

    Background saveBackground(Background background)throws ExceptionApp;

    List<Background> findAllbyIdClient(int idClient) throws ExceptionApp;

    Background modifyBackground(Background background);

    Background deleteBackground(Background background);


}
