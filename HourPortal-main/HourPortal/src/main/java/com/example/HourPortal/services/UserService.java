package com.example.HourPortal.services;

import com.example.HourPortal.models.User;
import com.example.HourPortal.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

//Anotacion de tipo servicio de spring
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    //Importa el repositorio de usuarios para poder acceder a el y manejar las solicitudes
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Metodo que crea un nuevo usuario en la base de datos
    public void registroUser(User user, Model model) {
        log.info("Registrando usuario");
        
        //Busca si ya existe algun usuario con esos datos en la base de datos
        User existingUser = userRepository.findByCorreoUnabAndContraseña(user.getCorreoUnab(), user.getContraseña());
       
        //Verifica que todos los campos esten llenos
        if(user.getCorreoUnab() == null || user.getContraseña() == null || user.getCorreoUnab().isEmpty() || user.getContraseña().isEmpty()){
            
            log.info("falta algun campo");
            
            model.addAttribute("errorRegistroVacio", "Porfavor rellene todos los campos");
            
        }
        
        //Verifica que no exista ningun usuario y guarda el usuario 
        if(existingUser != null){
           
             userRepository.save(user);
            log.info("Se ha registrado correctamente");
            model.addAttribute("validacionRegistro", "Se ha registrado correctamente");
             
            
        }else{
            
            model.addAttribute("errorRegistro", "Este correo ya ha sido registrado"); 
            log.info("El usuario ya existe");
            
          
        }
        
    }
}
