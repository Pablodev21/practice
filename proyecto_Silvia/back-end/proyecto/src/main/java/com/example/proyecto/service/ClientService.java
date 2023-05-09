package com.example.proyecto.service;

import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Client;
import com.example.proyecto.model.User;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client saveClient(Client client)throws ExceptionApp;

    Optional findByName(String client) throws ExceptionApp;

    List<Client> findAllClients();

    List<Client> find8FirstClients();

    Client modifyClient(Client client);

    Client deleteClient(Client client);

    Client getClient();

}
