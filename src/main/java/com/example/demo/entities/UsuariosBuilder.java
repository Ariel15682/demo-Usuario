package com.example.demo.entities;

// Es ejemplo, entities no es el mejor lugar para poner para poner esta clase. Las clases patrones siempre comienzan con
//entidad y siguen con el nombre del patron.
public class UsuariosBuilder {

    private final Usuario usuario = new Usuario();

    private UsuariosBuilder() { }

    //obligatorio el paso de nombreUsuario
    //Los atributos se pueden inicializar aqui o en la entidad para que no de error el builder
    public UsuariosBuilder(String nombreUsuario){
        usuario.nombre = "";
        usuario.apellidos = "";
        usuario.email = "";
        usuario.nivelAcceso = 0;
        usuario.nombreUsuario = nombreUsuario;
    }

    public UsuariosBuilder conNombre(String nombre){
        usuario.nombre = nombre.length() > 0 ? usuario.nombre : "sin nombre";
        return this;
    }

    public UsuariosBuilder conApellido(String apellidos){
        usuario.apellidos = apellidos.length() > 0 ? usuario.apellidos : "sin apellidos";
        return this;
    }

    public UsuariosBuilder conEmail(String email){
        usuario.email = email.length() > 0 ? usuario.email : "sin email";
        return this;
    }

    public UsuariosBuilder conNivelAcceso(int nivelAcceso){
        usuario.nivelAcceso = nivelAcceso > 0 ? usuario.nivelAcceso : 0;
        return this;
    }

    public Usuario build(){
        return usuario;
    }
}
