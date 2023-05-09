package com.example.proyecto.controller;


import com.example.proyecto.model.Client;
import com.example.proyecto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fisioSilvia/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getClients")
    public ResponseEntity<?> getListClients(){

        List<Client> clients = clientService.findAllClients();

        if(!clients.isEmpty()){
            return ResponseEntity.ok(clients);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Clients found");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Clients")
    public ResponseEntity<?> get8ListClients(){

        List<Client> clients = clientService.find8FirstClients();

        if(!clients.isEmpty()){
            return ResponseEntity.ok(clients);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Clients found");
        }
    }
}
