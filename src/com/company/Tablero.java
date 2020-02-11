package com.company;

public class Tablero {
    private Tile[][] pozo;
    private Pieza pieza;

    public Tablero(){
        this.pieza = new Pieza();
        this.pozo = new Tile[10][10];
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
                if(i == 9 || j == 0 || j == 9)
                    if(j==0||j==9){
                        pozo[i][j] = new Tile(true, true, 6,i,j);
                    } else {
                        pozo[i][j] = new Tile(true, false, 1,i,j);
                    }

                else if(i == 0) pozo[i][j] = new Tile(false, false, 0,i,j);
                else pozo[i][j] = new Tile(false, false,0,i,j);
            }
        }
    }

    public void moverIzda(){//a
        moverPieza(0,-1);
    }
    public void moverDcha(){//d
        moverPieza(0,1);
    }
    public void moverAbajo(){//I
        moverPieza(1,0);
    }
    public void moverArriba(){//I
        moverPieza(-1,0);
    }


    public void moverPieza(int incX, int incY){
        //si donde me quiero mover no es un borde o no esta ocupado, me muevo
        boolean puedo = true;
        boolean pegopared = false;
        for(Tile aux : pieza.getLista()){
            Tile dondeMeQuieroMover = pozo[aux.getCoordX() + incX][aux.getCoordY()+incY];
            if(dondeMeQuieroMover.isWall()) {
                pegopared = true;
            }
            if(dondeMeQuieroMover.isOccupied()) {
                puedo = false;
                break;
            }
        }
        if(puedo){
            for(Tile aux : pieza.getLista()){
                pozo[aux.getCoordX()][aux.getCoordY()] = new Tile(false,false, 0,aux.getCoordX(),aux.getCoordY());
                aux.setCoordY(aux.getCoordY()+incY);
                aux.setCoordX(aux.getCoordX()+incX);
            }
        } else {
            System.out.println("Movimiento invalido");
            if(!pegopared) {
                fijarPieza();
                this.pieza = new Pieza();
            }
        }
        for(Tile aux : pieza.getLista()){
            pozo[aux.getCoordX()][aux.getCoordY()] = aux;
        }

    }

    public void rotarPieza(){
        int miX,miY,nuevoX,nuevoY;
        boolean puedo = true;
        int pivotX = pieza.getLista().get(1).getCoordX(); //aqui le dices que coja el segundo. le puedes poner el que quieras
        int pivotY = pieza.getLista().get(1).getCoordY();
        for(Tile aux : pieza.getLista()){
            miX = aux.getCoordX();
            miY = aux.getCoordY();

            nuevoX = miY + pivotX - pivotY;
            nuevoY = pivotX + pivotY - miX;

            if(pozo[nuevoX][nuevoY].isOccupied()){
                puedo = false;
                break;
            }
            if(puedo){
                aux.setCoordX(nuevoX);
                aux.setCoordY(nuevoY);

                pozo[miX][miY] = new Tile(false,false, 0,miX,miY);
                pozo[aux.getCoordX()][aux.getCoordY()] = aux;
            }
        }
    }
    public void fijarPieza(){
        for(Tile aux : pieza.getLista()){
            pozo[aux.getCoordX()][aux.getCoordY()].setOccupied(true);
        }
    }

    public void imprimirPozo(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 10;j++){
                System.out.print("[" + this.pozo[i][j].getValue() + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
}
