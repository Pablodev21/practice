package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.User;
import com.example.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByLogin(User user) throws ExceptionApp;

    List<User> findAllUsers();

    User modifyUser(User user);

    User deleteUser(User user);

    User getConfirmLogin(String login,String password);

    User getUser();


}
