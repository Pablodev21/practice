package com.example.proyecto.controller;


import com.example.proyecto.dto.BackgroundDTO;
import com.example.proyecto.dto.EvaluationDTO;
import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.Background;
import com.example.proyecto.model.Evaluation;
import com.example.proyecto.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fisioSilvia/evaluations")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/save")
    public ResponseEntity<?> saveEvaluation(@RequestBody EvaluationDTO evaluationDTO) throws ExceptionApp, com.example.proyecto.excepcions.ExceptionApp {

        Optional<Evaluation> evaluationChecked = evaluationService.findById(evaluationDTO.getId());
        if ( !evaluationChecked.isPresent()) {
            Evaluation evaluationSaved = evaluationDTO.toModel();
            evaluationService.saveEvaluation(evaluationSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(evaluationSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Save This Evaluation " );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getEvaluations/{idClient}")
    public ResponseEntity<?> findAllIdClient(@PathVariable Integer idClient){
        List<Evaluation> listEvaluations = evaluationService.findAllidClient(idClient);
        if(!listEvaluations.isEmpty()){
            return ResponseEntity.ok(listEvaluations);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Evaluations");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Evaluations")

    public ResponseEntity<?> get8Evaluations(){
        List<Evaluation> listEvaluations=evaluationService.get8Evaluations();
        if(!listEvaluations.isEmpty()){
            return ResponseEntity.ok(listEvaluations);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Evaluations ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get8Evaluations/{idClient}")

    public ResponseEntity<?> get8EvaluationsIdClient(@PathVariable Integer idClient){
        List<Evaluation> listEvaluations = evaluationService.get8IdClient(idClient);
        if(!listEvaluations.isEmpty()){
            return ResponseEntity.ok(listEvaluations);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can Not Find Evaluations ");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> deleteEvaluationByIdClient(@PathVariable int id) {
        Optional<Evaluation> evaluationChecked = evaluationService.findById(id);
        if (evaluationChecked.isPresent()) {
            evaluationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Can Not Delete This Evaluation" );
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modify/{id}")
    public ResponseEntity<?> modifyEvaluation(@RequestBody Evaluation evaluation, @PathVariable int id) {

        this.evaluationService.modifyEvaluation(evaluation,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluation);
    }



}
