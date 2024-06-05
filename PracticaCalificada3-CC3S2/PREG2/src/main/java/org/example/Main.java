package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Habitacion hab1=new Habitacion("actual");
        Habitacion hab2=new Habitacion("Bosque");
        Habitacion hab3=new Habitacion("Biblioteca");

        Jugador jugador=new Jugador(hab1);
        Juego juego=new Juego(jugador);

        //Se añaden las habitaciones al juego
        juego.addRoom(hab1);
        juego.addRoom(hab2);
        juego.addRoom(hab3);
        //Se añade la habitación 2 y 3 como salidas de la habitación 1
        hab1.addSalidas(hab2);
        hab1.addSalidas(hab3);

        juego.turno();

    }
}