package org.example;

public class Tower {
    private int damage;
    private int range;
    private int fireRate; // turnos entre disparos
    private int tipo; // Define qué tipo de torre es. 10 = CannonTower, 11=LaserTower

    public Tower(int damage, int range, int fireRate) {
        this.damage=damage;
        this.range=range;
        this.fireRate=fireRate;
    }


    // Getters y Setters

    public int getTipo() {
        return tipo;
    }
    public int getDamage() {
        return damage;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getRange() {
        return range;
    }

}

