package com.example.HourPortal.controllers;

import com.example.HourPortal.models.User;
import com.example.HourPortal.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Anotaciones de spring, Controller = manejar solicitudes https y devolver vistar en thymeleaf, RestController sirve para manejar solamente datos
@Controller

//Anotacion de lombok para poder manejar las notas por consola
@Slf4j

//el controlador del login
public class LoginController {

    //Se importa el repositorio de los usuarios para acceder a la base de datos
    private final UserRepository userRepository;


    //Autowired que sirve para inyectar dependencias
    @Autowired

    //Constructor para importar el repositorio de usuarios
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Manejo de solicitudes principal para mostrar el login de primeras
    @GetMapping("/")
    public String login(Model model) {
        log.info("Se está ejecutando el login");
        return "Login";
    }

    //Envio de informacion a la base de datos para validar usuarios en el login
    @PostMapping("/Login")

    //Metodo que autoentica los usuarios, se piden los parametros correo y contraseña
    public String autenticar(@RequestParam("correoUnab") String correoUnab, @RequestParam("contraseña") String contraseña, Model model){

        log.info("Se está validando");

        //Se busca el usuario por correo y contraseña en la base de datos
        User user = userRepository.findByCorreoUnabAndContraseña(correoUnab, contraseña);

        if(user != null){
            log.info("Inicio de sesión exitosa!");
            return "Home";
        } else {
            log.info("Credenciales inválidas");

            //Se crea un mensaje de error para mostrarse en el thymeleaf
            model.addAttribute("error", "Correo o contraseña incorrectas");
            return "Login";
        }
    }
}
