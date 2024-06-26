package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TowerTest {
    @Test
    void testConstructor(){
        //Se cumple la precondición
        assertDoesNotThrow(() -> new Tower('L'));
        assertDoesNotThrow(() -> new Tower('C'));

        //No se cumple la precondición
        assertThrows(IllegalArgumentException.class, () -> new Tower('A'));
        assertThrows(IllegalArgumentException.class, () -> new Tower('1'));
        assertThrows(IllegalArgumentException.class, () -> new Tower('@'));
    }
}
