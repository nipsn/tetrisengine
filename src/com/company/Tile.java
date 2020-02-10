package com.company;

public class Tile {
    private boolean isOccupied;
    private boolean isWall;
    private int value;
    private int coordX;
    private int coordY;

    public Tile(boolean isOccupied, boolean isWall, int value, int x, int y) {
        this.isOccupied = isOccupied;
        this.isWall = isWall;
        this.value = value;
        this.coordX = x;
        this.coordY = y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public boolean isWall() {
        return isWall;
    }
}
