package com.example.proyecto.controller;


import com.example.proyecto.model.Background;
import com.example.proyecto.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fisioSilvia/background")
public class BackgroundController  {

    @Autowired
    BackgroundService backgroundService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getBackgroundIdClient/{idClient}")

    public ResponseEntity<?> getListBackgroundToClient(@RequestBody int idClient){

        List<Background> backgrounds = backgroundService.findBackgroundToIdClient(idClient);

        if(!backgrounds.isEmpty()){
            return ResponseEntity.ok(backgrounds);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No backgrounds found");
        }
    }
}
