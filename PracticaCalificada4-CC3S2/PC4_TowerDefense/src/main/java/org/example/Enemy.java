package org.example;

public class Enemy {
    private int speed; // número de celdas por turno
    private int health;
    private int reward;

    private int tipo; // Define qué tipo de Enemigo es. 30 = Enemigo Basico, 31= Enemigo Rapido, 32= Boss Enemy

    public Enemy(int speed, int health, int reward) {
        this.speed=speed;
        this.health=health;
        this.reward=reward;
    }

    //getters y setters
    public int getTipo(){
        return tipo;
    }

    public int getSpeed(){
        return speed;
    }
    public int getHealth(){
        return health;
    }
    public int getReward(){
        return reward;
    }
}
