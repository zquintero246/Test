package com.example.HourPortal.controllers;

import com.example.HourPortal.models.User;
import com.example.HourPortal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    //Se importan los servicios del usuario para poder manejar solicitudes a la base de datos
    private final UserService userService;


    //El controlador importa el UserService con userService
    @Autowired
    public RegistroController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/Registro")

    //Se crea un modelo User vacio para llenarlo con el forms del thymeleaf y devuelve la vista registro
    public String registro(Model model) {
        model.addAttribute("user", new User());
        return "Registro";
    }



    @PostMapping("/Registro")

    //Metodo post que llama el atributo del modelo user y se guarda un usuario en la base de datos con el metodo "registroUser", luego se devuelve la vista login
    public String UserRegistrado(@ModelAttribute("user") User user, Model model) {
        userService.registroUser(user, model);
        return "Login";
    }
}
