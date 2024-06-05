package org.example;

public class ConsoleGraphics implements Graphics{

    @Override
    public void drawText(String text){
        System.out.println(text);
    }
    @Override
    public void drawHorizontalLine(int width){
        var rowText = new StringBuilder();
        for (int i = 0; i < width; i++) {
            rowText.append('X');
        }
        System.out.println(rowText.toString());
    }
}
