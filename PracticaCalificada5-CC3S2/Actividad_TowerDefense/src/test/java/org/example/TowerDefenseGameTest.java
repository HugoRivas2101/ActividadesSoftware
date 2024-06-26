package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
public class TowerDefenseGameTest {
    @Mock
    private Map mockMap;
    @Mock
    private Player mockPlayer;
    @Mock
    private List<Wave> mockWaves;
    @InjectMocks
    private TowerDefenseGame game;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testPlaceTower() {
        //Se crea un mock de la clase Tower
        Tower mockTower = mock(Tower.class);
        //Se ejecuta el método
        game.placeTower(mockTower, 2, 2);
        //Se comprueba que el mock ha sido llamado al momento de ejecutar el método
        verify(mockMap).placeTower(mockTower, 2, 2);
    }
    @Test
    public void testStartWave(){
        Wave mockWave=mock(Wave.class);
        when(mockWaves.add(any(Wave.class))).thenReturn(true);
        game.startWave();
        verify(mockWaves).add(any(Wave.class));
    }
}


