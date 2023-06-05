package com.example.proyecto.controller;

import com.example.proyecto.dto.UserDTO;
import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.User;
import com.example.proyecto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fisioSilvia/user")
public class UserController {


    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/login/{nameLogin}/{password}")
    public ResponseEntity<?> enterLogin(@PathVariable String nameLogin,@PathVariable String password ) throws ExceptionApp{
        Boolean confirmed = userService.getConfirmLogin(nameLogin,password);

        if(confirmed){
           return ResponseEntity.status(HttpStatus.ACCEPTED).body(confirmed);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(confirmed);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) throws ExceptionApp {

        Optional <User>userChecked = userService.findByLogin(userDTO.getLogin());
        if (checklengthFields(userDTO).equals("") && !userChecked.isPresent()) {
            User userSaved = userDTO.toModel();
            userService.saveUser(userSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
        } else if (!checklengthFields(userDTO).equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body ("Exceeded length in the following field(s): " + checklengthFields(userDTO));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user who you wanted to create already exist");
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/getUsers")
    public ResponseEntity<?> getUsers() throws ExceptionApp {

        List <User>listUsers = userService.get8Users();
        if (!listUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(listUsers);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There are no users");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/modUser/{id}")
    public ResponseEntity<?> modifyUser(@RequestBody User user, @PathVariable int id ) throws ExceptionApp {

        List <User>listUsers = userService.get8Users();
        if (!listUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(listUsers);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There are no users");
        }
    }


    // Función para gestionar el tamaño de los campos introducidos
    public String checklengthFields(UserDTO userDTO) {
        List<String> invalidFields = new ArrayList<>();
        String msg = "";

        if (userDTO.getLogin().length() > 50) {
            invalidFields.add("login");
        } else if (userDTO.getPassword().length() > 100) {
            invalidFields.add("password");
        } else if (userDTO.getRol().length() > 10) {
            invalidFields.add("rol");
        }

        if (invalidFields.size() != 0) {
            for (int i = 0; i < invalidFields.size(); i++) {
                if (i != invalidFields.size() - 1) {
                    msg += invalidFields.get(i) + ", ";
                } else {
                    msg += invalidFields.get(i);
                }
            }
            return msg;
        } else {
            return msg;
        }
    }
}
