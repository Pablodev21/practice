package com.example.proyecto.controller;


import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Client;
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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Background " );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBackgroundIdClient/{idClient}")

    public ResponseEntity<?> getListBackgroundToClient (@PathVariable Integer idClient){

        List<Background> backgrounds = backgroundService.findAllByClientId(idClient);

        if(!backgrounds.isEmpty()){
            System.out.println(backgrounds);
            return ResponseEntity.ok(backgrounds);
        }else{
            System.out.println(backgrounds);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No backgrounds found");
        }
    }
    /*
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/modify/{idClient}")

    public ResponseEntity<?> updateBackgroundByClientId (@RequestBody BackgroundDTO backgroundDto){

      Optional <Background> backgroundChecked = backgroundService.findBackgroundByIdClient(backgroundDto.getIdClient());
      Background backgroundModified = new Background();
        if(backgroundChecked.isPresent()){
            backgroundModified= backgroundChecked;

           backgroundService.saveBackground(backgroundChecked);
           return ResponseEntity.ok(backgroundChecked);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No backgrounds modified ");
        }
    }
    */


}
