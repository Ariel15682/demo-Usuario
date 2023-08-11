package com.example.demo.services;

import com.example.demo.entities.Usuario;
import com.example.demo.entities.UsuariosBuilder;
import com.example.demo.repositories.UsuariosDB;
import com.example.demo.repositories.UsuariosDBFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuariosService {

    String tipoDeBBDD = "fichero";
    UsuariosDBFactory usuariosDBFactory = new UsuariosDBFactory(tipoDeBBDD);
    UsuariosDB usuariosDB= usuariosDBFactory.getDatabaseInstance();


    public ArrayList<Usuario> listarUsuarios() {
        return usuariosDB.obtener();
    }

    public Usuario obtenerUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        return usuariosDB.buscar(usuario);
    }

    public void crearUsuario(Usuario usuario) {

        if (usuariosDB.buscar(usuario) != null) {
            return;
        }

        Usuario usuarioFiltrado = crearUsuarioReal(usuario);

        usuariosDB.insertar(usuarioFiltrado);
    }

    private Usuario crearUsuarioReal(Usuario usuario) {
        UsuariosBuilder usuariosBuilder = new UsuariosBuilder(usuario.nombreUsuario);

        return  usuariosBuilder
                .conNombre(usuario.nombre)
                .conApellido(usuario.apellidos)
                .conEmail(usuario.email)
                .conNivelAcceso(usuario.nivelAcceso)
                .build();
    }

    public void borrarUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        usuariosDB.borrar(usuario);
    }
}
