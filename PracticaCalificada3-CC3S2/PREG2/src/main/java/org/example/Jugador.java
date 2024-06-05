package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    public Habitacion habitacionActual;
    public List<Objeto> objetos=new ArrayList<>();
    public Jugador(Habitacion habitacionActual){
        this.habitacionActual=habitacionActual;
    }
    public Habitacion getHabitacionActual(){
        return habitacionActual;
    }
    public void agarrarObjetoInRoom(){
        objetos.add(habitacionActual.getObjetosInRoom());
    }

    public void moveHabitacion(Habitacion nextRoom){
        if(habitacionActual.getSalidas().contains(nextRoom)){
            System.out.println("Te mueves de habitacion ");
            setHabitacionActual(nextRoom);
        }
        else{
            System.out.println("No puedes ir a esa habitacion");
        }
    }
    public void setHabitacionActual(Habitacion newRoom){
        habitacionActual=newRoom;
    }
    public int countObjetos(){
        return objetos.size();
    }

}
