package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Juego {
    public List<Habitacion> rooms=new ArrayList<>();
    Jugador jugador;

    public Juego(Jugador jugador){
        this.jugador=jugador;
    }

    public void turno(){

        System.out.println("Estás en una habitación oscura. Las salidas son ");

        for(Habitacion hab: jugador.getHabitacionActual().getSalidas()){
            System.out.println(hab.nombre);
        }

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        jugador.moveHabitacion(getHabitacionByName(inputString));
    }

    public void addRoom(Habitacion habitacion){
        rooms.add(habitacion);
    }
    public int getNumberRooms(){
        return rooms.size();
    }
    public Habitacion getHabitacionByName(String name){
        for(Habitacion hab : rooms){
            if(hab.nombre.equals(name)){
                return hab;
            }
        }
        return null;
    }
}
