package com.example.proyecto.dto;


import com.example.proyecto.model.Surgerie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurgerieDTO {

    private int id;

    private int idClient;

    private String description;

    private Date date;

    // Método para pasar de model a dto //
    public Surgerie toModel(){
        Surgerie surgerie = new Surgerie();

        surgerie.setId(this.id);
        surgerie.setIdClient(this.idClient);
        surgerie.setDescription(this.description);
        surgerie.setDate(this.date);

        return surgerie;
    }


    // Método para pasar de dto a model //
    public SurgerieDTO toDTO(Surgerie surgerie){

        this.setId(surgerie.getId());
        this.setIdClient(surgerie.getIdClient());
        this.setDescription(surgerie.getDescription());
        this.setDate(surgerie.getDate());


        return this;

    }



}
