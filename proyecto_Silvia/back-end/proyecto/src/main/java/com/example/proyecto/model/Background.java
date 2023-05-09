package com.example.proyecto.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "backgrounds")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Background {

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
    private Date date;


    // Relación con clase cliente //
    @ManyToOne
    @JoinColumn(name = "idCLient", insertable = false, updatable = false)
    @JsonBackReference
    private Client client;
}
