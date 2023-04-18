package com.example.proyecto.dto;


import com.example.proyecto.model.Allergie;
import com.example.proyecto.model.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {

    private int id;

    private int idClient;

    private String description;

    private Date date;


    // Método para pasar de model a dto //
    public Evaluation toModel(){
        Evaluation evaluation = new Evaluation();

        evaluation.setId(this.id);
        evaluation.setIdClient(this.idClient);
        evaluation.setDescription(this.description);
        evaluation.setDate(this.date);

        return evaluation;
    }


    // Método para pasar de dto a model //
    public EvaluationDTO toDTO(Evaluation evaluation){


        this.setId(evaluation.getId());
        this.setIdClient(evaluation.getIdClient());
        this.setDescription(evaluation.getDescription());
        this.setDate(evaluation.getDate());


        return this;

    }




}
