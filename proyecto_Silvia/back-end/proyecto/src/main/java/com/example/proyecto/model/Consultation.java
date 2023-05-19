package com.example.proyecto.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "consultations")
@NoArgsConstructor
@AllArgsConstructor

public class Consultation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idClient")
    private int idClient;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="date")
    private Date date;

    // Relación con clase cliente //
    @ManyToOne
    @JoinColumn(name = "idCLient", insertable = false, updatable = false)
    @JsonBackReference
    private Client client;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
