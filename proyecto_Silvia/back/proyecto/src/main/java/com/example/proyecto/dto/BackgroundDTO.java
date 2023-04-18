package com.example.proyecto.dto;


import com.example.proyecto.model.Background;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundDTO {


    private int id;

    private int idClient;

    private String description;

    private Date date;


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
