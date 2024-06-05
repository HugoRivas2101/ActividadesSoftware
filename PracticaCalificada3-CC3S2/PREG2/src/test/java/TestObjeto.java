import org.example.Habitacion;
import org.example.Jugador;
import org.example.Objeto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObjeto {

    @Test
    void addObjetoRoomTest(){
        Habitacion hab1 = new Habitacion("Biblioteca");
        Objeto obj1=new Objeto("Bomba");
        hab1.addObjetos(obj1);
        assertEquals("Bomba",hab1.getObjetosInRoom().nombre);
    }

    @Test
    void getObjetoTest() {
        Habitacion hab1 = new Habitacion("Biblioteca");
        Objeto obj1=new Objeto("Bomba");
        hab1.addObjetos(obj1);
        Jugador jugador = new Jugador(hab1);
        jugador.agarrarObjetoInRoom();
        assertEquals(1,jugador.countObjetos());
    }
}
