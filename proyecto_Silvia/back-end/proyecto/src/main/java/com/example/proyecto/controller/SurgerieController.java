package com.example.proyecto.controller;

import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.dto.SurgerieDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Surgerie;
import com.example.proyecto.service.BackgroundService;
import com.example.proyecto.service.SurgerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/surgeries")
public class SurgerieController {

    @Autowired
    SurgerieService surgerieService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveSurgerie(@RequestBody SurgerieDTO surgerieDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Surgerie> surgerieChecked = surgerieService.findById(surgerieDTO.getId());
        if ( !surgerieChecked.isPresent()) {
            Surgerie surgerieSaved = surgerieDTO.toModel();
            surgerieService.saveSurgerie(surgerieSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(surgerieSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Surgerie" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getSurgeries/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Surgerie> listSurgeries = surgerieService.findAllidClient(idClient);
        if(!listSurgeries.isEmpty()){
            return ResponseEntity.ok(listSurgeries);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Surgeries");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Surgeries")

    public ResponseEntity<?> get8Surgeries(){
        List<Surgerie> listSurgeries=surgerieService.get8Surgeries();
        if(!listSurgeries.isEmpty()){
            return ResponseEntity.ok(listSurgeries);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Surgeries ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Surgeries/{idClient}")

    public ResponseEntity<?> get8SurgeriesIdClient(@PathVariable Integer idClient){
        List<Surgerie> listSurgeries = surgerieService.get8IdClient(idClient);
        if(!listSurgeries.isEmpty()){
            return ResponseEntity.ok(listSurgeries);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Surgeries ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteSurgerieByIdClient(@PathVariable int id) {
        Optional<Surgerie> surgerieChecked = surgerieService.findById(id);
        if (surgerieChecked.isPresent()) {
            surgerieService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Surgerie" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifySurgerie(@RequestBody Surgerie surgerie, @PathVariable int id) {
        this.surgerieService.modifySurgerie(surgerie,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(surgerie);
    }
}
