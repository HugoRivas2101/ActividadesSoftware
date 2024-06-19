package org.example;

public class Main {
    public static void main(String[] args) {

        Map map=new Map();
        map.inicializarMap();
        map.mostrarMap();

        TowerFactory factory = new CannonTowerFactory();
        Tower cannonTower = factory.createTower();

        System.out.println("Creacion de CannonTower:\nDamage:" + cannonTower.getDamage());
        System.out.println("Rango: " + cannonTower.getRange());
        System.out.println("Alcance de disparo: " + cannonTower.getFireRate());


    }
}