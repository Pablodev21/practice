package com.example.proyecto.controller;


import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/backgrounds")
public class BackgroundController  {

    @Autowired
    BackgroundService backgroundService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveBackground(@RequestBody BackgroundDTO backgroundDto) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Background> backgroundChecked = backgroundService.findById(backgroundDto.getId());
        if ( !backgroundChecked.isPresent()) {
            Background backgroundSaved = backgroundDto.toModel();
            backgroundService.saveBackground(backgroundSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(backgroundSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Background ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBackgrounds/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Background> listBackgrounds=backgroundService.findAllidClient(idClient);
        if(!listBackgrounds.isEmpty()){
            return ResponseEntity.ok(listBackgrounds);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Backgrounds");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Backgrounds")

    public ResponseEntity<?> get8Backgrounds(){
        List<Background> listBackgrounds=backgroundService.get8Backgrounds();
        if(!listBackgrounds.isEmpty()){
            return ResponseEntity.ok(listBackgrounds);

        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Backgrounds");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Backgrounds/{idClient}")

    public ResponseEntity<?> get8BackgroundsIdClient(@PathVariable Integer idClient){
        List<Background> listBackgrounds=backgroundService.get8IdClient(idClient);
        if(!listBackgrounds.isEmpty()){
            return ResponseEntity.ok(listBackgrounds);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Backgrounds ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteBackgroundByIdClient(@PathVariable int id) {
        Optional<Background> backgroundChecked = backgroundService.findById(id);
        if (backgroundChecked.isPresent()) {
            backgroundService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Background" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyBackground(@RequestBody Background background, @PathVariable int id) {

        this.backgroundService.modifyBackground(background,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(background);
    }

}
