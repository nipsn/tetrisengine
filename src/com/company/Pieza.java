package com.company;

import java.util.ArrayList;

public class Pieza {
    private ArrayList<Tile> lista;
    //private int tipo;
    private int estado;
    public Pieza(){
        //asumo que es un cuadrado
        lista = new ArrayList<>();
        this.lista.add(new Tile(false,false,3, Main.SPAWNX, Main.SPAWNY));
        this.lista.add(new Tile(false,false,3,Main.SPAWNX+1, Main.SPAWNY));
        this.lista.add(new Tile(false,false,3,Main.SPAWNX+2, Main.SPAWNY));
        this.lista.add(new Tile(false,false,3,Main.SPAWNX+2, Main.SPAWNY+1));
        this.estado = 0;
    }

    public ArrayList<Tile> getLista() {
        return lista;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
