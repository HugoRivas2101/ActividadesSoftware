package org.example;

import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void testAdd(){
        Calculator calc=new Calculator();
        assertEquals(5,calc.add(2,3));
    }
    @Test
    void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.substract(3, 2));
    }
    @Test
    void testMultiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
    }
    @Test
    void testDivide() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Calculator calc = new Calculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
        assertEquals("Divisor cannot be zero", exception.getMessage());
    }

    @Test
    void testCalculateAdd(){
        Calculator calc=new Calculator();
        assertEquals(5,calc.calculate("add",3,2));
    }

    @Test
    void testCalculateSubtract(){
        Calculator calc=new Calculator();
        assertEquals(1,calc.calculate("subtract",3,2));
    }

    @Test
    void testCalculateMultiply(){
        Calculator calc=new Calculator();
        assertEquals(6,calc.calculate("multiply",2,3));
    }

    @Test
    void testCalculateDivide(){
        Calculator calc=new Calculator();
        assertEquals(2,calc.calculate("divide",6,3));
    }

    @Test
    void testCalculateInvalidOperation(){
        Calculator calc=new Calculator();
        Exception exception=assertThrows(IllegalArgumentException.class, ()->calc.calculate("mod",1,1));
        assertEquals("Invalid operation",exception.getMessage());
    }

}
