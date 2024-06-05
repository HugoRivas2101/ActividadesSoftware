import org.example.Habitacion;
import org.example.Juego;
import org.example.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJuego {

    @Test
    void getHabitacionByName(){
        Habitacion hab1=new Habitacion("Biblioteca");
        Habitacion hab2=new Habitacion("Bosque");
        Jugador jugador= new Jugador(hab1);
        Juego juego=new Juego(jugador);
        //Se añaden las habitaciones al juego
        juego.addRoom(hab1);
        juego.addRoom(hab2);
        //Se añade la habitación 2 como salida de la habitación 1
        hab1.addSalidas(hab2);
        assertEquals(hab1,juego.getHabitacionByName("Biblioteca"));
    }

    @Test
    void testTurno(){

        Habitacion hab1=new Habitacion("biblioteca");
        Habitacion hab2=new Habitacion("bosque");
        Jugador jugador= new Jugador(hab1);
        Juego juego=new Juego(jugador);
        //Se añaden las habitaciones al juego
        juego.addRoom(hab1);
        juego.addRoom(hab2);
        //Se añade la habitación 2 como salida de la habitación 1
        hab1.addSalidas(hab2);

        assertEquals(1,hab1.countSalidas());
    }
}
