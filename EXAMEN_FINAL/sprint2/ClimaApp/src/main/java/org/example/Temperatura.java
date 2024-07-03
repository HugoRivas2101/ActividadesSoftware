package org.example;

public class Temperatura extends Condicion{
    private  double actual;//Temperatura actual
    private double limite=35; //Límite para que salte una alerta
    Temperatura(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limite;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Temperatura Alta!";
    }
}
