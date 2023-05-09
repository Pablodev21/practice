package com.example.proyecto.dto;


import com.example.proyecto.model.Evaluation;
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
public class EvaluationDTO {

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
