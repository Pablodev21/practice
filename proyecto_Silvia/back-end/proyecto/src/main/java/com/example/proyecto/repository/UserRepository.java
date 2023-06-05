package com.example.proyecto.repository;

import com.example.proyecto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {


    Optional<User> findByLoginIgnoreCase(String login);

    User deleteByLogin(String Login);

    @Query(value="SELECT * FROM users LIMIT 8 ", nativeQuery = true)
    List<User> getListaUsuario();

    void deleteById(int id);


}
