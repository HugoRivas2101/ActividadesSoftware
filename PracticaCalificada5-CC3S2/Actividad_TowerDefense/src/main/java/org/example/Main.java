package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TowerDefenseGame game=new TowerDefenseGame();
        game.placeTower(new Tower('C'), 2, 2);
        game.startWave();
        game.gameState();

    }
}