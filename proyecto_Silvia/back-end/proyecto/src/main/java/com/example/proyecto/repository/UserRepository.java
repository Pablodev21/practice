package com.example.proyecto.repository;

import com.example.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {


    Optional<User> findByLoginIgnoreCase(String login);

    User deleteByLogin(String Login);

}
