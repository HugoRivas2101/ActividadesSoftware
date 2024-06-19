package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TowerTest {

    @Test
    public void testCannonTower() {
        // Se crea el mock de Cannon Tower
        CannonTower mockCannonTower = Mockito.mock(CannonTower.class);
        // Se define que cuando llamas a getTipo, te retorne una torre Cannon, o sea, 10
        Mockito.when(mockCannonTower.getTipo()).thenReturn(10);
        // Verificar el comportamiento esperado
        assertEquals(10, mockCannonTower.getTipo());
    }
    @Test
    public void testLaserTower() {
        // Crear mock de LaserTower
        LaserTower mockLaserTower = Mockito.mock(LaserTower.class);
        // Se define que cuando llamas a getTipo, te retorne una torre Laser, o sea, 10
        Mockito.when(mockLaserTower.getTipo()).thenReturn(11);
        // Verificar el comportamiento esperado
        assertEquals(11, mockLaserTower.getTipo());
    }

}
