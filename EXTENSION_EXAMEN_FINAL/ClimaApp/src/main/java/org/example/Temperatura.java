package org.example;

public class Temperatura extends Condicion{
    private  double actual;//Temperatura actual
    private double limiteAlerta=35; //Límite para que salte una alerta
    private double limiteAccion=30; //Límite para realizar una acción

    Temperatura(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limiteAlerta;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Temperatura Alta!";
    }
    @Override
    public String getMensajeAccion(){
        return "Accion: Prendiendo el aire acondicionado...";
    }
    @Override
    public boolean evaluarAccion(){
        return actual>limiteAccion;
    }
}
