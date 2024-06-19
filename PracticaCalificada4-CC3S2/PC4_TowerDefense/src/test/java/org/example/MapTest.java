package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// SE HAN ORIGINADO ERRORES. FALTA CORREGIR LOS TESTS Y EL MÉTODO

public class MapTest {

    private Map map;
    private CannonTower mockCannonTower;
    private BasicEnemy mockBasicEnemy;

    @BeforeEach
    void setUp() {
        map = new Map();
        map.inicializarMap();
        mockCannonTower = Mockito.mock(CannonTower.class);
        mockBasicEnemy = Mockito.mock(BasicEnemy.class);
    }

    @Test
    void inicializarMapTest(){
        assertEquals(map.getMatriz()[0][0],0);
        assertEquals(map.getMatriz()[0][1],0);
    }

    @Test
    void placeTowerTest(){
        map.placeTower(mockCannonTower, 0, 0);
        assertEquals(10, map.getMatriz()[0][0]);
    }

    @Test
    void placeEnemyTest(){
        map.placeEnemy(mockBasicEnemy, 0, 0);
        assertEquals(30, map.getMatriz()[1][1]);
    }

    //Verifica el error cuando se trata de colocar una torre fuera de rango
    @Test
    void placeTowerOutside(){
        Map map=new Map();
        map.inicializarMap();
        //Creacion de mock para simular una torre
        CannonTower mockCannonTower = Mockito.mock(CannonTower.class);
        //Al tratar de setear la torre fuera del tablero, se origina un error.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            map.placeTower(mockCannonTower, 10, 10);
        });
    }
    @Test
    void placeTowerOverTower(){
        Map map=new Map();
        map.inicializarMap();
        //Creacion de mock para simular unas torres
        CannonTower mockCannonTower1 = Mockito.mock(CannonTower.class);
        CannonTower mockCannonTower2 = Mockito.mock(CannonTower.class);
        //Se setea una torre en el mapa

        //Al tratar de colocar una torre sobre otra torre, se origina un error.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            map.placeTower(mockCannonTower2, 0, 0);
        });
    }


}
