    package com.example.HourPortal.models;


    import lombok.Data;
    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;


    //Se usa la anotacion document de mongodb para relacionarlo con la collection users en la base de datos
    @Document(collection = "users")

    //Anotacion de lombok para ahorrar los getters y setters del modelo
    @Data
    public class User {

        //Se genera un id en la base de datos automatico
        @Id
        private String id;


            private String nombre;
            private String semestre;
            private String carrera;



            private String correoUnab;
            private String contraseña;
            private String idUnab;


            private int cantHoras;
    }
