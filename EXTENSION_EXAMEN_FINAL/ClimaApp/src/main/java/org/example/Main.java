package org.example;

public class Main {
    public static void main(String[] args) {
        // Se crea una instancia de la aplicación
        ClimaApp climaApp = new ClimaApp();
        // Se crean algunas condiciones
        Lluvia lluviaLeve = new Lluvia(15); // No genera alerta
        Viento vientoFuerte = new Viento(70); // Genera alerta
        Temperatura temperaturaAlta= new Temperatura(38);   // Genera alerta
        //Se añaden las condiciones
        climaApp.addCondition(lluviaLeve);
        climaApp.addCondition(vientoFuerte);
        climaApp.addCondition(temperaturaAlta);
        // Se muestran las alertas
        climaApp.evaluarCondiciones();
    }
}