package com.example.proyecto.dto;


import com.example.proyecto.model.Background;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/*
@Setter
@Getter
@ToString


@Data
@EqualsAndHashCode
*/
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundDTO {


    private int id;

    private int idClient;

    private String description;

    private String date;

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

    // Método para pasar de model a dto //
    public Background toModel(){
        Background background = new Background();

        background.setId(this.id);
        background.setIdClient(this.idClient);
        background.setDescription(this.description);
        background.setDate(this.date);


        return background;
    }


    // Método para pasar de dto a model //
    public BackgroundDTO toDTO(Background background){

        this.setId(background.getId());
        this.setIdClient(background.getIdClient());
        this.setDescription(background.getDescription());
        this.setDate(background.getDate());


        return this;

    }




}
