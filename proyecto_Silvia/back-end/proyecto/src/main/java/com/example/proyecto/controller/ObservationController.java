package com.example.proyecto.controller;

import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.dto.ObservationDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Observation;
import com.example.proyecto.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/observations")
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveObservation(@RequestBody ObservationDTO observationDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Observation> observationChecked = observationService.findById(observationDTO.getId());
        if ( !observationChecked.isPresent()) {
            Observation observationSaved = observationDTO.toModel();
            observationService.saveObservation(observationSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(observationSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Observation " );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getObservations/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Observation> listObservations = observationService.findAllidClient(idClient);
        if(!listObservations.isEmpty()){
            return ResponseEntity.ok(listObservations);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Observations");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Observations")

    public ResponseEntity<?> get8Observations(){
        List<Observation> listObservations = observationService.get8Observations();
        if(!listObservations.isEmpty()){
            return ResponseEntity.ok(listObservations);

        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Observations ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Observations/{idClient}")

    public ResponseEntity<?> get8ObservationsIdClient(@PathVariable Integer idClient){
        List<Observation> listObservations = observationService.get8IdClient(idClient);
        if(!listObservations.isEmpty()){
            return ResponseEntity.ok(listObservations);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Observations ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteObservationByIdClient(@PathVariable int id) {
        Optional<Observation> observationChecked = observationService.findById(id);
        if (observationChecked.isPresent()) {
            observationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Observation" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyObservation(@RequestBody Observation observation, @PathVariable int id) {

        this.observationService.modifyObservation(observation,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(observation);
    }
}
