import org.example.Acertijo;
import org.example.Habitacion;
import org.example.Juego;
import org.example.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAcertijo {
    @Test
    void acertijoInitTest(){
        Acertijo acertijo=new Acertijo("Te la digo, Te la digo","Tela");
        assertFalse(acertijo.cumplido);
    }

    @Test
    void acertijoSolveTest(){
        Acertijo acertijo=new Acertijo("Te la digo, Te la digo","Tela");
        acertijo.responder("Tela");
        assertTrue(acertijo.cumplido);
    }

}
