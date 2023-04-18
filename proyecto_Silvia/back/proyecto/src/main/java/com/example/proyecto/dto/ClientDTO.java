package com.example.proyecto.dto;

import com.example.proyecto.model.User;

public class ClientDTO {

    private int id;

    private String name;

    private String lastName;

    private int phone;

    private String dni;

    private String email;


    // Método para pasar de model a dto //
    public User toModel(){
        User user = new User();

        user.setId(this.id);
        user.setLogin(this.login);
        user.setPassword(this.password);
        user.setRol(this.rol);

        return user;
    }


    // Método para pasar de dto a model //
    public UserDTO toDTO(User user){

        this.setId(user.getId());
        this.setLogin(user.getLogin());
        this.setPassword(user.getPassword());
        this.setRol(user.getRol());


        return this;

    }
}
