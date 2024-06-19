package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class EnemyTest {
    @Test
    public void testBasicEnemy() {
        // Se crea el mock de Basic Enemy
        CannonTower mockCannonTower = Mockito.mock(CannonTower.class);
        // Se define que cuando llamas a getTipo, te retorne un Basic Enemy, o sea, 30
        Mockito.when(mockCannonTower.getTipo()).thenReturn(30);
        // Verificar el comportamiento esperado
        assertEquals(30, mockCannonTower.getTipo());
    }
    @Test
    public void testBossEnemy() {
        // Crear mock de Boss Enemy
        LaserTower mockLaserTower = Mockito.mock(LaserTower.class);
        // Se define que cuando llamas a getTipo, te retorne un Boss Enemy, o sea, 32
        Mockito.when(mockLaserTower.getTipo()).thenReturn(32);
        // Verificar el comportamiento esperado
        assertEquals(32, mockLaserTower.getTipo());
    }

}
