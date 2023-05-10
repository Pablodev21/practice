package com.example.proyecto.dto;


import com.example.proyecto.model.Treatment;
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
public class TreatmentDTO {


    private int id;

    private int idClient;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public Treatment toModel(){
        Treatment treatment = new Treatment();

        treatment.setId(this.id);
        treatment.setIdClient(this.idClient);
        treatment.setName(this.name);
        treatment.setDescription(this.description);
        treatment.setDate(this.date);

        return treatment;
    }


    // Método para pasar de dto a model //
    public TreatmentDTO toDTO(Treatment treatment){

        this.setId(treatment.getId());
        this.setIdClient(treatment.getIdClient());
        this.setName(treatment.getName());
        this.setDescription(treatment.getDescription());
        this.setDate(treatment.getDate());

        return this;

    }
}
