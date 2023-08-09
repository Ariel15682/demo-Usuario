package com.example.demo.repositories;

import com.example.demo.entities.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuariosDBMemoria extends UsuariosDB {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public ArrayList<Usuario> obtener() {
        return usuarios;
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        for (Usuario usuarioActual : obtener()) {
            if (usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void insertar(Usuario usuario) {

        usuarios.add(usuario);
        incrementarInserciones();
    }

    @Override
    public void borrar(Usuario usuario) {
        for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext(); ) {
            Usuario usuarioIterator = iterator.next();
            if (usuario.nombreUsuario.equalsIgnoreCase(usuarioIterator.nombreUsuario)) {
                iterator.remove();
            }
        }

//        for (int i = 0; i < usuarios.size(); i++) {
//            if (usuarios.get(i).nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
//                usuarios.remove(i);
//            }
//        }

        incrementarEliminaciones();
    }
}