package org.example;

public class Lluvia extends Condicion{

    private  double actual;//Lluvia actual
    private double limiteAlerta=20; //Límite para que salte una alerta
    private double limiteAccion=18; //Limite para que se realice una acción
    Lluvia(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limiteAlerta;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Lluvia Intensa!";
    }
    @Override
    public boolean evaluarAccion(){
        return actual>limiteAccion;
    }
    @Override
    public String getMensajeAccion(){
        return "Accion: Activar sistema de riego...";
    }

}
