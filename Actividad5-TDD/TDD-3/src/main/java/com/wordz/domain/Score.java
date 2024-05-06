package com.wordz.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Score {
    private final String correct;
    private Letter resultado = Letter.INCORRECT ;
    public Score(String correct) {
        this.correct = correct;
    }
    public Letter letter(int position) {
        return resultado;
    }

    //Evalua lo que debe de puntuar la adivinacion.
    //1er parámetro: índice de la letra a adivinar
    //2do parámetro: letra supuesta
    public void assess(int position, String attempt) {
        if (isCorrectLetter(position,attempt)) {
            resultado = Letter.CORRECT;
        }
    }

    private boolean isCorrectLetter(int position, String attempt){
        return correct.charAt(position)==attempt.charAt(position);
    }

}
