package com.example.proyecto.dto;

import com.example.proyecto.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private int id;

    private String name;

    private String lastName;

    private int phone;

    private String dni;

    private String email;

    private int LOPD;


    // Método para pasar de model a dto //
    public Client toModel(){
        Client client = new Client();


        client.setId(this.id);
        client.setName(this.name);
        client.setLastName(this.lastName);
        client.setPhone(this.phone);
        client.setDni(this.dni);
        client.setEmail(this.email);
        client.setLOPD(this.LOPD);

        return client;
    }


    // Método para pasar de dto a model //
    public ClientDTO toDTO(Client client){

        this.setId(client.getId());
        this.setName(client.getName());
        this.setLastName(client.getLastName());
        this.setPhone(client.getPhone());
        this.setDni(client.getDni());
        this.setEmail(client.getDni());
        this.setLOPD(client.getLOPD());


        return this;

    }



}
