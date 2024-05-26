package com.wordz.domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String correct;
    private final List<Letter> results=new ArrayList<>();
    private int position;
    public Score(String correct) {
        this.correct = correct;
    }
    public Letter letter(int position) {
        return results.get(position);
    }

    //Evalua lo que debe de puntuar la adivinacion.
    //parámetro: cadena supuesta
    public void assess(String attempt) {
        //Itera sobre cada letra del intento. Si una coincide, se cambia el valor de resultado
        for(char current:attempt.toCharArray()){
            //Añade cada score para cada letra
            results.add(scoreFor(current));
            position++;
        }
    }

    private Letter scoreFor(char current){
        //Retorna un valor según la letra. Puede estar en la posición correcta, puede estar
        //incluida o no puede estar en la palabra a adivinar.
        if(isCorrectLetter(current)){return Letter.CORRECT;}
        else if(occursInWord(current)){return Letter.PART_CORRECT;}
        else {return Letter.INCORRECT;}
    }

    private boolean occursInWord(char currentLetter){
        return correct.contains(String.valueOf(currentLetter));
    }

    private boolean isCorrectLetter(char currentLetter){
        return correct.charAt(position)==currentLetter;
    }
}
