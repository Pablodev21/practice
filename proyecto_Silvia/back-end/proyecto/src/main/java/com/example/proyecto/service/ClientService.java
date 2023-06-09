package com.example.proyecto.service;

import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Client;


import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client saveClient(Client client)throws ExceptionApp;

    List <Client> findByName(String client) throws ExceptionApp;

    Optional <Client> findById (int id);

    List <Client> findByDni (String dni);

    List <Client> findByPhone (int phone);

    List<Client> findAllClients();

    List<Client> find8FirstClients();

    List<Client> find16FirstClients();

    void modifyClient(Client client, int id);

    void deleteClient(int id);

    Client getClient();

}
