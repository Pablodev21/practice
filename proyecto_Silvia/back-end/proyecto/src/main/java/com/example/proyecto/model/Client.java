package com.example.proyecto.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {


    // Atributos propios //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phone")
    private int phone;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "LOPD")
    private int LOPD;


    // Relaciones //

    // Observaciones //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Observation> observations = new ArrayList<>();


    // Antecedentes //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Background> backgrounds = new ArrayList<>();


    // Cirugías //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Surgerie> surgeries = new ArrayList<>();


    // Tratamientos //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Treatment> treatments = new ArrayList<>();


    // Alergías //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Allergie> allergies = new ArrayList<>();


    // Evaluaciones //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Evaluation> evaluations = new ArrayList<>();

}
