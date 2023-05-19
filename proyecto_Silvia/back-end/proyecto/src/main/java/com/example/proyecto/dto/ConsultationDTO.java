package com.example.proyecto.dto;


import com.example.proyecto.model.Consultation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

public class ConsultationDTO {

    private int id;

    private int idClient;

    private String title;

    private String description;

    private Date date;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Método para pasar de model a dto //
    public Consultation toModel(){
        Consultation consultation = new Consultation();


        consultation.setId(this.id);
        consultation.setIdClient(this.idClient);
        consultation.setTitle(this.title);
        consultation.setDescription(this.description);
        consultation.setDate(this.date);

        return consultation;
    }


    // Método para pasar de dto a model //
    public ConsultationDTO toDTO(Consultation consultation){

        this.setId(consultation.getId());
        this.setIdClient(consultation.getIdClient());
        this.setTitle(consultation.getTitle());
        this.setDescription(consultation.getDescription());
        this.setDate(consultation.getDate());

        return this;
    }
}
