package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalasManager {
    private Map<Integer, Sala> salas;

    public SalasManager() {
        salas = new HashMap<>();
    }
    public void agregarSala(Sala sala) {
        salas.put(sala.getId(), sala);
    }
    public boolean eliminarSala(int id) {
        return salas.remove(id) != null;
    }
    public int contarSalas() {
        return salas.size();
    }
}
