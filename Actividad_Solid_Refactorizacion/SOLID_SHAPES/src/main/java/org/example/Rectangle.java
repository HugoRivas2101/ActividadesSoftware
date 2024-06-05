package org.example;

public class Rectangle implements Shape{

    int height;
    int width;

    public Rectangle(int height, int width){
        this.height=height;
        this.width=width;
    }
    public String getType(){
        return "Rectangulo";
    }

    @Override
    public void draw(Graphics g){
        for(int i=0; i<height; i++){
            g.drawHorizontalLine(width);
        }
    }

}
