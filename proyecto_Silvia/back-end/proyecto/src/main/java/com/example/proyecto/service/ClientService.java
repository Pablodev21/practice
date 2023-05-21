package com.example.proyecto.service;

import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Client;
import com.example.proyecto.model.User;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client saveClient(Client client)throws ExceptionApp;

    Optional findByName(String client) throws ExceptionApp;

    Optional findById (int id);

    List<Client> findAllClients();

    List<Client> find8FirstClients();

    List<Client> find16FirstClients();

    void modifyClient(Client client, int id);

    void deleteClient(int id);

    Client getClient();

}
