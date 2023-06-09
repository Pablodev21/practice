package com.example.proyecto.service;

import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user)throws ExceptionApp;

    Optional findByLogin(String login) throws ExceptionApp;

    Optional findById(int id);
    List<User> findAllUsers();

    User modifyUser(User user, int id);

    User deleteUser(User user);

    void delete(int id);

    Boolean getConfirmLogin(String login,String password);

    User getUser();

    List<User> get8Users();






}
