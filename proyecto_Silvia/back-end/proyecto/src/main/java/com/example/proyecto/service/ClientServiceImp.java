package com.example.proyecto.service;

import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Client;
import com.example.proyecto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    @Transactional
    public Client saveClient(Client client) throws ExceptionApp {

        Optional<Client> clientFinded = repository.findByNameIgnoreCase(client.getName());
        if(!clientFinded.isPresent()){
            return repository.save(client);

        }else{
            throw new ExceptionApp("Cant create the client");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional findByName(String client) throws ExceptionApp {
        return Optional.empty();
    }

    @Override
    public Optional findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAllClients() {
        return repository.findAll();
    }

    @Override
    public List<Client> find8FirstClients() {
        return repository.find8FirstClients();
    }

    @Override
    public List<Client> find16FirstClients() {
        return repository.find16FirstClients();
    }

    @Override
    public void modifyClient(Client client,int id) {
        Optional<Client> clientChecked = this.repository.findById(id);

        Client clientModify= clientChecked.get();

        clientModify.setName(client.getName());
        clientModify.setLastName(client.getLastName());
        clientModify.setPhone(client.getPhone());
        clientModify.setDni(client.getDni());
        clientModify.setEmail(client.getEmail());
        clientModify.setLOPD(client.getLOPD());

        this.repository.save(clientModify);
    }

    @Override
    public void deleteClient(int id) {
        repository.deleteById(id);
    }

    @Override
    public Client getClient() {
        return null;
    }
}
