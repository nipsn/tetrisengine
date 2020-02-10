package com.company;

public class Main {
    public static final int SPAWNX = 1;
    public static final int SPAWNY = 5;
    public static Tablero tablero;
    public static void main(String[] args) {
        tablero = new Tablero();
        //X ES EL EJE VERTICAL E Y EL HORIZONTAL
        tablero.imprimirPozo();

        tablero.moverAbajo();
        tablero.moverAbajo();

        tablero.imprimirPozo();

        tablero.rotarPieza();
        tablero.imprimirPozo();
        tablero.rotarPieza();
        tablero.imprimirPozo();
        tablero.rotarPieza();
        tablero.imprimirPozo();
        tablero.rotarPieza();
        tablero.imprimirPozo();



    }
}
