package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClimaAppTest {

    @Mock
    private Condicion condicionMock;

    private ClimaApp climaApp;

    @BeforeEach
    public void setUp() {
        climaApp = new ClimaApp();
    }

    @Test
    public void testAddCondition() {
        climaApp.addCondition(condicionMock);//Se usa un mock de condicion y se añade a clima app
        List<Condicion> condiciones = climaApp.getCondiciones();
        assertEquals(1, condiciones.size());// Se verifica que el tamaño de la lista de  condiciones aumente
        assertEquals(condicionMock, condiciones.get(0)); //Se verifica que el primer elemento de la lista es el mock creado
    }
    @Test
    public void testEvaluarCondiciones() {

        //Se crean los mocks para las distintas condiciones
        Condicion lluviaMock = mock(Lluvia.class);
        Condicion vientoMock = mock(Viento.class);
        //Se declaran las salidas de los métodos llamados
        when(lluviaMock.evaluarAlerta()).thenReturn(true);
        when(lluviaMock.evaluarAccion()).thenReturn(true);
        when(lluviaMock.getMensajeAlerta()).thenReturn("Alerta: Lluvia Intensa!");
        when(lluviaMock.getMensajeAccion()).thenReturn("Accion: Prendiendo el aire acondicionado...");
        when(vientoMock.evaluarAlerta()).thenReturn(false);
        //Se añaden las condiciones creadas
        climaApp.addCondition(lluviaMock);
        climaApp.addCondition(vientoMock);
        //Se llama a la función para evaluar las condiciones y mandar el mensaje de alerta si el valor es mayor que el límite
        climaApp.evaluarCondiciones();
        //Se verifica que se ha interactuado con los mocks
        verify(lluviaMock, times(1)).evaluarAlerta();
        verify(vientoMock, times(1)).evaluarAlerta();
        //Se debe de haber llamado al método mensaje alerta porque la alerta es verdadera
        verify(lluviaMock, times(1)).getMensajeAlerta();
    }


}
