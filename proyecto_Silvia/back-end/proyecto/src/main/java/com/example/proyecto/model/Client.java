package com.example.proyecto.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor


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

    @Column(name = "DNI")
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

    // Consultas //
    @OneToMany(mappedBy = "idClient", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Consultation> consultations = new ArrayList<>();


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

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public List<Background> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(List<Background> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public List<Surgerie> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgerie> surgeries) {
        this.surgeries = surgeries;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public List<Allergie> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergie> allergies) {
        this.allergies = allergies;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
