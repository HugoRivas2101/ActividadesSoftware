package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CondicionTest{
    @Test
    public void testEvaluarAlertaLluviaTrue() {
        Lluvia lluvia = new Lluvia(25); // Mayor que el límite
        assertTrue(lluvia.evaluarAlerta());
    }

    @Test
    public void testEvaluarAlertaLluviaFalse() {
        Lluvia lluvia = new Lluvia(15); // Menor que el límite
        assertFalse(lluvia.evaluarAlerta());
    }
    @Test
    public void testEvaluarAlertaVientoTrue() {
        Viento viento = new Viento(70); // Mayor que el límite
        assertTrue(viento.evaluarAlerta());
    }

    @Test
    public void testEvaluarAlertaVientoFalse() {
        Viento viento = new Viento(40); // Menor que el límite
        assertFalse(viento.evaluarAlerta());
    }
    @Test
    public void testEvaluarAlertaTemperaturaTrue() {
        Temperatura temperatura = new Temperatura(40); // Mayor que el límite
        assertTrue(temperatura.evaluarAlerta());
    }
    @Test
    public void testEvaluarAlertaTemperaturaFalse() {
        Temperatura temperatura = new Temperatura(15); // Menor que el límite
        assertFalse(temperatura.evaluarAlerta());
    }

}
