package org.example;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
public class Shapes {
    private final List<Shape> allShapes = new ArrayList<>();
    private final Graphics g;

    Shapes(Graphics g){
        this.g=g;
    }
    public void add(Shape s) {
        allShapes.add(s);
    }
    public void draw(Graphics g) {
        for (Shape s : allShapes) {
            s.draw(g);
        }
    }
}
