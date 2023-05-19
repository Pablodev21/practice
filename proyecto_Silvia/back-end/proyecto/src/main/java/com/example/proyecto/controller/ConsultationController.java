package com.example.proyecto.controller;


import com.example.proyecto.dto.ConsultationDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Consultation;
import com.example.proyecto.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/consultations")
public class ConsultationController {

    @Autowired
    ConsultationService consultationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveConsultation(@RequestBody ConsultationDTO consultationDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Consultation> consultationChecked = consultationService.findById(consultationDTO.getId());
        if ( !consultationChecked.isPresent()) {
            Consultation consultationSaved = consultationDTO.toModel();
            consultationService.saveConsultation(consultationSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(consultationSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Consultation" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getConsultations/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Consultation> listConsultations = consultationService.findAllidClient(idClient);
        if(!listConsultations.isEmpty()){
            return ResponseEntity.ok(listConsultations);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Consultations");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Consultations")

    public ResponseEntity<?> get8Consultations(){
        List<Consultation> listConsultations = consultationService.get8Consultations();
        if(!listConsultations.isEmpty()){
            return ResponseEntity.ok(listConsultations);

        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Consultations ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8BConsultations/{idClient}")

    public ResponseEntity<?> get8ConsultationsIdClient(@PathVariable Integer idClient){
        List<Consultation> listConsultations = consultationService.get8IdClient(idClient);
        if(!listConsultations.isEmpty()){
            return ResponseEntity.ok(listConsultations);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Backgrounds ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteConsultationByIdClient(@PathVariable int id) {
        Optional<Consultation> consultationChecked = consultationService.findById(id);
        if (consultationChecked.isPresent()) {
            consultationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Consultation" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyConsultation(@RequestBody Consultation consultation, @PathVariable int id) {

        this.consultationService.modifyConsultation(consultation,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(consultation);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/today/{date}")
    public ResponseEntity<?> listTodayConsultations(@PathVariable Date date){
        List<Consultation> listConsultation = consultationService.getTodayConsultations(date);

        if(!listConsultation.isEmpty()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(listConsultation);

        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can Not Find Consultations for today");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/today/{date}/{idClient}")
    public ResponseEntity<?> listTodayClientConsul(@PathVariable Date date,@PathVariable int idClient){

        List<Consultation> listConsultation = consultationService.getTodayClientConsul(date, idClient);

        if(!listConsultation.isEmpty()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(listConsultation);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not find Consultations for today for this client");
        }

    }
}
