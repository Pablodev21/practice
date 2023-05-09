package com.example.proyecto.dto;


import com.example.proyecto.model.Observation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservationDTO {

    private int id;

    private int idClient;

    private String description;

    private Date date;


    // Método para pasar de model a dto //
    public Observation toModel(){
        Observation observation = new Observation();

        observation.setId(this.id);
        observation.setIdClient(this.idClient);
        observation.setDescription(this.description);
        observation.setDate(this.date);

        return observation;
    }


    // Método para pasar de dto a model //
    public ObservationDTO toDTO(Observation observation){

        this.setId(observation.getId());
        this.setIdClient(observation.getIdClient());
        this.setDescription(observation.getDescription());
        this.setDate(observation.getDate());


        return this;

    }

}
