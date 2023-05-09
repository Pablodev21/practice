package com.example.proyecto.dto;


import com.example.proyecto.model.User;
import lombok.*;


/*
@Setter
@Getter
@ToString


@Data
@EqualsAndHashCode
*/
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;

    private String login;

    private String password;

    private String rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

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
