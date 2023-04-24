package com.example.proyecto.service;

import com.example.proyecto.exceptions.ExceptionApp;
import com.example.proyecto.model.User;
import com.example.proyecto.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User saveUser(User user) throws ExceptionApp {
        Optional<User> userFinded = repository.findByLoginIgnoreCase(user.getLogin());
        if(!userFinded.isPresent()){
            return repository.save(user);
        }else{
            throw new ExceptionApp("Cant create the user");
        }
    }

    @Override
    public Optional <User> findByLogin(String login) throws ExceptionApp {
        return repository.findByLoginIgnoreCase(login);
    }


    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User modifyUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User getConfirmLogin(String login, String password) {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }
}
