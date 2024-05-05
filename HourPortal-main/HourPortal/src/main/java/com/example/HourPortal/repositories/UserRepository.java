package com.example.HourPortal.repositories;


import com.example.HourPortal.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


//Interfaz publica que extiende el repositorio de mongo e importa el usuario y valores de tipo string
public interface UserRepository extends MongoRepository<User, String> {

    //Metodo que busca en la base de datos por correoUnab y contraseña
    User findByCorreoUnabAndContraseña(String correoUnab, String contraseña);
    User findByCorreoUnab(String correoUnab);
}
