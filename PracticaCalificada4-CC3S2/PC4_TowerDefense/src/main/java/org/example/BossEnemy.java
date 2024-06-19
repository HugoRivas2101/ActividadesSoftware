package org.example;

public class BossEnemy extends Enemy {
    public BossEnemy() {
        super(1, 300, 30); // velocidad, vida, recompensa
    }
    @Override
    public int getTipo() {
        return 32;
    }
}
