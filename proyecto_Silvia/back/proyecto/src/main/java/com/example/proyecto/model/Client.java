package com.example.proyecto.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Alumnos")
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







    public Client(int id, String name, String lastName, int phone, String dni, String email, List<Observation> observaciones, List<Background> backgrounds, List<Surgerie> surgeries, List<Treatment> treatments, List<Allergie> allergies, List<Evaluation> evaluations) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.dni = dni;
        this.email = email;
        this.observaciones = observaciones;
        this.backgrounds = backgrounds;
        this.surgeries = surgeries;
        this.treatments = treatments;
        this.allergies = allergies;
        this.evaluations = evaluations;
    }


    // Relaciones //

    // Observaciones //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Observation> observaciones = new ArrayList<>();


    // Antecedentes //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Background> backgrounds = new ArrayList<>();


    // Cirugías //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Surgerie> surgeries = new ArrayList<>();


    // Tratamientos //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Treatment> treatments = new ArrayList<>();


    // Alergías //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Allergie> allergies = new ArrayList<>();


    // Evaluaciones //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();

}
