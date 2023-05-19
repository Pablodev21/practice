package com.example.proyecto.dto;

import com.example.proyecto.model.Client;
import lombok.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLOPD() {
        return LOPD;
    }

    public void setLOPD(int LOPD) {
        this.LOPD = LOPD;
    }

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
