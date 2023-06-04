package com.example.proyecto.controller;


import com.example.proyecto.dto.TreatmentDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Treatment;
import com.example.proyecto.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/treatments")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveTreatment(@RequestBody TreatmentDTO treatmentDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Treatment> treatmentChecked = treatmentService.findById(treatmentDTO.getId());
        if ( !treatmentChecked.isPresent()) {
            Treatment treatmentSaved = treatmentDTO.toModel();
            treatmentService.saveTreatment(treatmentSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(treatmentSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Treatment " );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTreatments/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Treatment> listTreatments = treatmentService.findAllidClient(idClient);
        if(!listTreatments.isEmpty()){
            return ResponseEntity.ok(listTreatments);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Treatments");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Treatments")

    public ResponseEntity<?> get8Treatments(){
        List<Treatment> listTreatments=treatmentService.get8Treatments();
        if(!listTreatments.isEmpty()){
            return ResponseEntity.ok(listTreatments);

        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Treatments ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Treatments/{idClient}")

    public ResponseEntity<?> get8TreatmentsIdClient(@PathVariable Integer idClient){
        List<Treatment> listTreatments = treatmentService.get8IdClient(idClient);
        if(!listTreatments.isEmpty()){
            return ResponseEntity.ok(listTreatments);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Treatments ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteTreatment(@PathVariable int id) {
        Optional<Treatment> treatmentChecked = treatmentService.findById(id);
        if (treatmentChecked.isPresent()) {
            treatmentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Treatment" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyTreatment(@RequestBody Treatment treatment, @PathVariable int id) {

        this.treatmentService.modifyTreatment(treatment,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(treatment);
    }
}
