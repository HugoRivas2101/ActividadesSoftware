package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClimaApp {
    private List<Condicion> condiciones; //Lista de condiciones a evaluar
    public ClimaApp() {
        this.condiciones = new ArrayList<>();
    }
    public void addCondition(Condicion condicion) { //Añadir condiciones
        this.condiciones.add(condicion);
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }
    public void evaluarCondiciones() {
        for (Condicion condicion : condiciones) { //Se itera a través de todas las condiciones agregadas

            if(condicion.evaluarAccion()){// Se evalua si se cumple la condicion para realizar la acción.
                System.out.println(condicion.getMensajeAccion());
            }
            if (condicion.evaluarAlerta()) { //Se evalua cada condición y se muestra el mensaje de alerta cuando el valor excede al límite
                System.out.println(condicion.getMensajeAlerta());
            }
        }
    }
}
