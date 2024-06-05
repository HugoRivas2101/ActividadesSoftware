import org.example.Habitacion;
import org.example.Juego;
import org.example.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {
    @Test
    void moveRoomTest(){

        Habitacion hab1=new Habitacion("Biblioteca");
        Habitacion hab2=new Habitacion("Bosque");
        Jugador jugador=new Jugador(hab1);
        //Se añaden las habitaciones al juego
        Juego juego=new Juego(jugador);
        juego.addRoom(hab1);
        juego.addRoom(hab2);
        //Se añade la habitación 2 como salida de la habitación 1
        hab1.addSalidas(hab2);
        //Se situa la ubicación inicial del jugador

        jugador.moveHabitacion(hab2);
        //Se hace la prueba para ver si la ubicación actual es la sala 2
        assertEquals(hab2,jugador.getHabitacionActual());
    }

    @Test
    void getCurrentRoom(){
        Habitacion hab1=new Habitacion("Biblioteca");
        Jugador jugador=new Jugador(hab1);
        //Se añaden las habitaciones al juego
        Juego juego=new Juego(jugador);
        juego.addRoom(hab1);
        //Se hace la prueba para ver si la ubicación actual es la sala 1
        assertEquals(hab1,jugador.getHabitacionActual());
    }
    @Test
    void getSalidasTest(){

        Habitacion hab1=new Habitacion("Biblioteca");
        Habitacion hab2=new Habitacion("Bosque");
        Jugador jugador=new Jugador(hab1);
        //Se añaden las habitaciones al juego
        Juego juego=new Juego(jugador);
        juego.addRoom(hab1);
        juego.addRoom(hab2);
        //Se añade la habitación 2 como salida de la habitación 1
        hab1.addSalidas(hab2);
        //Se hace la prueba para ver si la salida es hab2
        assertEquals(hab2,jugador.getHabitacionActual().getSalidas().get(0));
    }
}
