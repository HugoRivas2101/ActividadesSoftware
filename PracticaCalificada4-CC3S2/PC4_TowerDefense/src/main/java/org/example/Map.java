package org.example;

public class Map {
    private int[][] matriz;
    private int tamano=5;

    public Map() {
        this.matriz = new int[tamano][tamano];
    }

    public void inicializarMap() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                this.matriz[i][j] = 0; // 0 representa casilla libre
            }
        }
        //colocarCaminoYBaseDefault();
    }

    public void placeTower(Tower tower, int x, int y) {
        if (x < 0 || x >= matriz.length || y < 0 || y >= matriz[0].length) {
            throw new IllegalArgumentException("Posicion no disponible");
        }
        if (matriz[x][y] != 0) {
            throw new IllegalArgumentException("Casilla ocupada");
        }
        matriz[x][y] = tower.getTipo(); //10 REPRESENTA UNA TORRE - CANNON, 11 es TORRE - LASER
    }

    public void placeEnemy(Enemy enemy, int x, int y) {
        if (x < 0 || x >= matriz.length || y < 0 || y >= matriz[0].length) {
            throw new IllegalArgumentException("Posicion no disponible");
        }
        if (matriz[x][y] != 0) {
            throw new IllegalArgumentException("Casilla Ocupada");
        }
        matriz[x][y] = enemy.getTipo(); //30 REPRESENTA UN ENEMY-SIMPLE, 31 es ENEMY-FAST, 32 es ENEMY-BOSS
    }
/*
    public void colocarCaminoYBaseDefault(){
        matriz[0][2]=1;
        matriz[1][1]=1;
        matriz[2][0]=1;
        matriz[3][1]=1;
        matriz[3][2]=1;
        matriz[2][3]=1;
        matriz[2][4]=2;
    }

 */
    public void mostrarMap(){
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("\n");
        }
    }

    public int[][] getMatriz(){
        return matriz;
    }
}
