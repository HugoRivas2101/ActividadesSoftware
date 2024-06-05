package org.example;

public class Main {
    public static void main(String[] args) {

        Graphics console=new ConsoleGraphics();

        //DIP: Se inyectan las dependencias
        var shapes=new Shapes(console);
        //A la clase Shapes se le pueden agregar diferentes tipos de Shape
        //SRP: Cada tipo de Shape sabe como dibujar su forma
        //LSP: Cada subclase se puede usar donde se necesite una interfaz de forma
        shapes.add(new TextBox("Hello!"));
        shapes.add(new Rectangle(2,8));
        shapes.add(new RightArrow());
    }
}