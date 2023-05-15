package com.example.proyecto.controller;


import com.example.proyecto.dto.AllergieDTO;
import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Allergie;
import com.example.proyecto.model.Background;
import com.example.proyecto.service.AllergieService;
import com.example.proyecto.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/allergies")
public class AllergieController {

    @Autowired
    AllergieService allergieService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ResponseEntity<?> saveAllergie(@RequestBody AllergieDTO allergieDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Allergie> allegieChecked = allergieService.findById(allergieDTO.getId());
        if (!allegieChecked.isPresent()) {
            Allergie allergieSaved = allergieDTO.toModel();
            allergieService.saveAllergie(allergieSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(allergieSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Allergie " );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllergies/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Allergie> listAllergies=allergieService.findAllidClient(idClient);
        if(!listAllergies.isEmpty()){
            return ResponseEntity.ok(listAllergies);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Allergies");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Allergies")

    public ResponseEntity<?> get8Allergies(){
        List<Allergie> listAllergies=allergieService.get8Allergies();
        if(!listAllergies.isEmpty()){
            return ResponseEntity.ok(listAllergies);

        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Backgrounds ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Allergies/{idClient}")

    public ResponseEntity<?> get8BackgroundsIdClient(@PathVariable Integer idClient){
        List<Allergie> listAllergies=allergieService.get8IdClient(idClient);
        if(!listAllergies.isEmpty()){
            return ResponseEntity.ok(listAllergies);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Allergies ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteAllergie(@PathVariable int id) {
        Optional<Allergie> allergieChecked = allergieService.findById(id);
        if (allergieChecked.isPresent()) {
            allergieService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Allergie" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyAllergie(@RequestBody Allergie allergie, @PathVariable int id) {

        this.allergieService.modifyAllergie(allergie,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allergie);
    }
}
