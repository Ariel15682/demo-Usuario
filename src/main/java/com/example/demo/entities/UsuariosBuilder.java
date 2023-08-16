package com.example.demo.entities;

import jakarta.validation.constraints.NotBlank;


/**
 * La clase UsuariosBuilder implementa  implementa el patron "builder" para la creacion de un objeto Usuario con ciertas
 * caracteristicas. En el caso de no completar los campos de nombre, apellidos, email autocompleta con un valor por
 * defecto "sin nombre", "sin apellido"...
 */

//INFORMATIVO: Ariel15682@11/08/23 - Se incorpora el uso de anotacion "@NotNull"

/* INTENCIONALIDAD: Con el uso de la anotacion "NotNull" provista por Spring se pretende hacer obligatorio completar
* el campo nombreUsuario (username) */

//ATRIBUCION: Codigo Original: https://github.com/Ariel15682/demo-Usuario por @Ariel15682

// MENCIONES: Si quedan dudas hablar con @Ariel15682

public class UsuariosBuilder {

    private final Usuario usuario = new Usuario();

    private UsuariosBuilder() { }

    public UsuariosBuilder(@NotBlank String nombreUsuario){
//        usuario.nombre = "";
//        usuario.apellidos = "";
//        usuario.email = "";
//        usuario.nivelAcceso = 0;
        usuario.nombreUsuario = nombreUsuario;
    }

    public UsuariosBuilder conNombre(String nombre){
        usuario.nombre = nombre.length() > 0 ? nombre : "sin nombre";
        return this;
    }

    public UsuariosBuilder conApellido(String apellidos){
        usuario.apellidos = apellidos.length() > 0 ? apellidos : "sin apellidos";
        return this;
    }

    public UsuariosBuilder conEmail(String email){
        usuario.email = email.length() > 0 ? email : "sin email";
        return this;
    }

    public UsuariosBuilder conNivelAcceso(int nivelAcceso){
        usuario.nivelAcceso = nivelAcceso > 0 ? nivelAcceso : 0;
        return this;
    }

    public Usuario build(){
        return usuario;
    }
}
