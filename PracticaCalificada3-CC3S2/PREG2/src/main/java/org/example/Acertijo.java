package org.example;

public class Acertijo {
    public String pregunta;
    public String respuesta;
    public Boolean cumplido;

    public Acertijo(String pregunta, String respuesta){
        this.pregunta=pregunta;
        this.respuesta=respuesta;
        cumplido=false;
    }

    public void responder(String ans){
        if(ans.equals(respuesta)){
            cumplido=true;
            System.out.println("Acertijo resuelto");
        }
        System.out.println("Mala respuesta :(");
    }

    public boolean getCumplido(){
        return cumplido;
    }
}
