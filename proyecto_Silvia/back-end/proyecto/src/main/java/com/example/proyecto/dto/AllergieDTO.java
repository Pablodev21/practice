package com.example.proyecto.dto;


import com.example.proyecto.model.Allergie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergieDTO {

    private int id;

    private int idClient;

    private String description;





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
