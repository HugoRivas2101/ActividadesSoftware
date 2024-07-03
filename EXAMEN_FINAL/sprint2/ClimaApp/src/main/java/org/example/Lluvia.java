package org.example;

public class Lluvia extends Condicion{

    private  double actual;//Lluvia actual
    private double limite=20; //Límite para que salte una alerta
    Lluvia(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limite;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Lluvia Intensa!";
    }

}
