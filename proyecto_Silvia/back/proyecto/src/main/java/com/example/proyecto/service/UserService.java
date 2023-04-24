package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.User;
import com.example.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user)throws ExceptionApp;

    Optional findByLogin(String login) throws ExceptionApp;

    List<User> findAllUsers();

    User modifyUser(User user);

    User deleteUser(User user);

    User getConfirmLogin(String login,String password);

    User getUser();


}
