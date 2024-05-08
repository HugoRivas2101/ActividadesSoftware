package org.example;

public class Question {

    String enunciado;
    String options[];
    int correcta;

    public Question(String enunciado, String[] options, int correcta){
        this.enunciado=enunciado;
        this.options=options;
        this.correcta=correcta;
    }
}
