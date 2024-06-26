package org.example;

public class Tower {
    private char symbol;

    public Tower(char symbol) {
        // Precondición: Los símbolos deben ser C o L, para representar Cannon Tower o Laser Tower
        if (symbol != 'C' && symbol != 'L') {
            throw new IllegalArgumentException("Torre no disponible");
        }
        this.symbol = symbol;
        assert Character.isLetter(symbol) : "Se debe ingresar un caracter";
    }

    public char getSymbol() {
        return symbol;
    }
}