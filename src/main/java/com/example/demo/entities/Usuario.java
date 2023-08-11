package com.example.demo.entities;

/**
 * La clase Usuarios implementa diversos metodos para la gestion del modelo "Usuario". La misma contiene sus atributos,
 * y metodo toString(). No posee de metodos getters & setters (inmutable).
 *
 * @see
 *
 * @since 19/05/2023
 */

public class Usuario {
    public String nombreUsuario = "";
    public String nombre = "";
    public String apellidos  = "";
    public String email = "";
    public int nivelAcceso = 0;

    @Override
    public String toString() {
        return   "nombre de usuario: " + nombreUsuario + "\r\n"
                + "nombre: " + nombre + "\r\n"
                + "apellidos: " + apellidos + "\r\n"
                + "email: " + email + "\r\n"
                + "nivel de acceso: " + nivelAcceso;
    }
}
