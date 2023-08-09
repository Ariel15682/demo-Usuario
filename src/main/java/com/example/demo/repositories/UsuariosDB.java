package com.example.demo.repositories;

import com.example.demo.entities.Usuario;

import java.util.ArrayList;

public abstract class UsuariosDB {

    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    public int getTotalInserciones() { return totalInserciones; }
    public int getTotalEliminaciones() { return totalEliminaciones; }

    protected void incrementarInserciones() { totalInserciones++; }
    protected void incrementarEliminaciones() { totalEliminaciones++; }

    public abstract ArrayList<Usuario> obtener();
    public abstract Usuario buscar(Usuario usuario);
    public abstract void insertar(Usuario usuario);
    public abstract void borrar(Usuario usuario);
}