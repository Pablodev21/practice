package com.example.proyecto.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;




@Entity
@Table(name = "observations")
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "idClient")
    private int idClient;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date")
    private String date;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
