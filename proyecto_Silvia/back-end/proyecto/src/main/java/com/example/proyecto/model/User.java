package com.example.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column (name="password")
    private String password;

    @NotNull
    @Column(name = "rol")
    private String rol;


    public User(String login, String password, String rol) {
        this.login = login;
        this.password = password;
        this.rol = rol;
    }
}
