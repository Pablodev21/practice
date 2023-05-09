package com.example.proyecto.dto;


import com.example.proyecto.model.Observation;
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
public class ObservationDTO {

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
