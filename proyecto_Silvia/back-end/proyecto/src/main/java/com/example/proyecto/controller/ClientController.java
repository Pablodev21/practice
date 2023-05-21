package com.example.proyecto.controller;


import com.example.proyecto.dto.ClientDTO;
import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Client;
import com.example.proyecto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createClient")
    public ResponseEntity<?> saveUser(@RequestBody ClientDTO clientDto) throws ExceptionApp {

        Optional<Client> clientChecked = clientService.findById(clientDto.getId());
        if (clientChecked.isEmpty()) {
            Client clientSaved = clientDto.toModel();
            clientService.saveClient(clientSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Client ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getClients")
    public ResponseEntity<?> getListClients(){

        List<Client> clients = clientService.findAllClients();

        if(!clients.isEmpty()){
            return ResponseEntity.ok(clients);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Clients found");
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get16Clients")
    public ResponseEntity<?> get16ListClients(){

        List<Client> clients = clientService.find16FirstClients();

        if(!clients.isEmpty()){
            return ResponseEntity.ok(clients);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Clients fo und");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyClient(@RequestBody Client client, @PathVariable int id) throws ExceptionApp {

        this.clientService.modifyClient(client,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteClientById(@PathVariable int id) {
        Optional<Client> clientChecked = clientService.findById(id);
        if (clientChecked.isPresent()) {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Client" );
        }
    }

}
