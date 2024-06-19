package org.example;

public class Game {

    Map map;
    public Game(Map map){
        this.map=map;
    }


    public void placeTower(String towerType, int x, int y) {
        TowerFactory factory;
        switch (towerType) {
            case "Laser":
                factory= new LaserTowerFactory();
            case "Cannon":
                factory = new CannonTowerFactory();
                break;
            default:
                throw new IllegalArgumentException("No existe ese tipo de torre.");
        }
        Tower tower = factory.createTower();
        map.placeTower(tower, x, y);
        System.out.println("Torre " + towerType + " colocada en (" + x + ", " + y + ")");
        map.mostrarMap();
    }

    public void placeEnemy(String enemyType, int x, int y) {
        EnemyFactory factory;
        switch (enemyType) {
            case "Basic":
                factory= new BasicEnemyFactory();
            case "Boss":
                factory = new BossEnemyFactory();
                break;
            default:
                throw new IllegalArgumentException("No existe ese tipo de Enemigo.");
        }
        Enemy enemy = factory.createEnemy();
        map.placeEnemy(enemy, x, y);
        map.mostrarMap();
    }
}
