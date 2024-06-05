package org.example;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {

    public List<Habitacion> salidas=new ArrayList<>();
    public Objeto objetoInRoom;

    public String nombre;

    public Habitacion(String nombre){
        this.nombre=nombre;
    }

    public void addSalidas(Habitacion habitacion){
        salidas.add(habitacion);
    }

    public void addObjetos(Objeto obj){
        objetoInRoom=obj;
    }
    public int countSalidas(){
        return salidas.size();
    }

    public List<Habitacion> getSalidas(){
        return salidas;
    }
    public Objeto getObjetosInRoom(){
        return objetoInRoom;
    }
}
