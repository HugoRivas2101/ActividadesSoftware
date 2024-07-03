package org.example;

public class Viento extends Condicion{
    private  double actual;//velocidad viento actual
    private double limiteAlerta=45; //Límite para que salte una alerta
    private double limiteAccion=40; //Límite para que se realice una acción
    Viento(double actual){
        this.actual=actual;
    }
    @Override
    public boolean evaluarAlerta() {
        return actual > limiteAlerta;
    }
    @Override
    public String getMensajeAlerta() {
        return "Alerta: Vientos Fuertes!";
    }

    @Override
    public boolean evaluarAccion(){
        return actual>limiteAccion;
    }
    @Override
    public String getMensajeAccion(){
        return "Accion: Cerrando las ventanas ...";
    }
}
