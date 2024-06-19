package org.example;

public class LaserTower extends Tower{
    public LaserTower() {
        super(20, 4, 3); // daño, alcance, velocidad de disparo
    }

    @Override
    public int getTipo() {
        return 10;
    }
}
