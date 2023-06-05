package com.example.proyecto.service;


import com.example.proyecto.excepcions.ExceptionApp;
import com.example.proyecto.model.User;
import com.example.proyecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repository;


    @Override
    @Transactional
    public User saveUser(User user) throws ExceptionApp {
        Optional<User> userFinded = repository.findByLoginIgnoreCase(user.getLogin());
        if(!userFinded.isPresent()){
            return repository.save(user);

        }else{
            throw new ExceptionApp("Cant create the user");

        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional <User> findByLogin(String login) throws ExceptionApp {
        return repository.findByLoginIgnoreCase(login);
    }

    @Override
    public Optional findById(int id) {
        return repository.findById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User modifyUser(User user, int id) {
        Optional<User> userChecked = this.repository.findById(id);

        User userModify= userChecked.get();
        userModify.setId(user.getId());
        userModify.setLogin(user.getLogin());
        userModify.setPassword(user.getPassword());
        userModify.setRol(user.getRol());

       return this.repository.save(userModify);
    }

    @Override
    public User deleteUser(User user) {
        return repository.deleteByLogin(user.getLogin());
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }


    @Override
    @Transactional
    public Boolean getConfirmLogin(String login, String password) {

       Optional<User> userChecked = repository.findByLoginIgnoreCase(login);
       if(userChecked.isPresent()){
        User user = userChecked.get();
        if(user.getPassword().equals(password)){
            return true;

        }else{
            return false;
        }
       }else{
           return false;
       }
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public List<User> get8Users() {
        return repository.getListaUsuario();
    }
}
