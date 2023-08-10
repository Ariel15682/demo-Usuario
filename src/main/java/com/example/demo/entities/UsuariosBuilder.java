package com.example.demo.entities;

public class UsuariosBuilder {

    private final Usuario usuario = new Usuario();

    private UsuariosBuilder() { }

    public UsuariosBuilder(String nombreUsuario){
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
