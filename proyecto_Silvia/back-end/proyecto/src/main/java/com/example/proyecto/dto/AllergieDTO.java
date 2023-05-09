package com.example.proyecto.dto;


import com.example.proyecto.model.Allergie;
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

public class AllergieDTO {

    private int id;

    private int idClient;

    private String description;



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

    // Método para pasar de model a dto //
    public Allergie toModel(){
        Allergie allergie = new Allergie();

        allergie.setId(this.id);
        allergie.setIdClient(this.idClient);
        allergie.setDescription(this.description);

        return allergie;
    }


    // Método para pasar de dto a model //
    public AllergieDTO toDTO(Allergie allergie){

        this.setId(allergie.getId());
        this.setIdClient(allergie.getIdClient());
        this.setDescription(allergie.getDescription());


        return this;

    }



}
