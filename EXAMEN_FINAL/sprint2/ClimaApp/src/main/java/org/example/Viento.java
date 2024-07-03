package org.example;

public class Viento extends Condicion{
    private  double actual;//velocidad viento actual
    private double limite=50; //Límite para que salte una alerta
    Viento(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limite;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Vientos Fuertes!";
    }
}
