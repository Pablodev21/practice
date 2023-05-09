package com.example.proyecto.dto;


import com.example.proyecto.model.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDTO {


    private int id;

    private int idClient;

    private String description;

    private Date date;


    // Método para pasar de model a dto //
    public Treatment toModel(){
        Treatment treatment = new Treatment();

        treatment.setId(this.id);
        treatment.setIdClient(this.idClient);
        treatment.setDescription(this.description);
        treatment.setDate(this.date);

        return treatment;
    }


    // Método para pasar de dto a model //
    public TreatmentDTO toDTO(Treatment treatment){

        this.setId(treatment.getId());
        this.setIdClient(treatment.getIdClient());
        this.setDescription(treatment.getDescription());
        this.setDate(treatment.getDate());


        return this;

    }
}
