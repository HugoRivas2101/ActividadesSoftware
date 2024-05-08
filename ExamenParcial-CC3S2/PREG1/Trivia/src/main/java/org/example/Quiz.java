package org.example;

public class Quiz {

    //Se realiza una lista de preguntas que serán mostradas secuencialmente
    Question[] ListaPreguntas=new Question[10];
    //La cantidad de preguntas por Quizz
    int contadorPreguntas;

    void Quizz(){
        contadorPreguntas=0;
    }
    public void addQuestion(Question question){
        ListaPreguntas[contadorPreguntas]=question;
        contadorPreguntas++;
    }
    public void showQuiz(){
    }
    public String addAnswerQuestion(int i){
        if(i==ListaPreguntas[0].correcta){
            return "Correcto";
        }
        return "Incorrecto";
    }
    public Question[] getListaPreguntas(){
        return ListaPreguntas;
    }
    public int getContadorPreguntas(){
        return contadorPreguntas;
    }



}
