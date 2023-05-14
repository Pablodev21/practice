package com.example.proyecto.dto;


import com.example.proyecto.model.Surgerie;
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
public class SurgerieDTO {

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
    public Surgerie toModel(){
        Surgerie surgerie = new Surgerie();

        surgerie.setId(this.id);
        surgerie.setIdClient(this.idClient);
        surgerie.setName(this.name);
        surgerie.setDescription(this.description);
        surgerie.setDate(this.date);

        return surgerie;
    }


    // Método para pasar de dto a model //
    public SurgerieDTO toDTO(Surgerie surgerie){

        this.setId(surgerie.getId());
        this.setIdClient(surgerie.getIdClient());
        this.setName(surgerie.getName());
        this.setDescription(surgerie.getDescription());
        this.setDate(surgerie.getDate());


        return this;

    }



}
