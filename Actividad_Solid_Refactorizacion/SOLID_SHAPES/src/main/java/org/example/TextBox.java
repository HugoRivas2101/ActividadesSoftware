package org.example;

public class TextBox implements Shape{

    private final String text;
    TextBox(String text){
        this.text=text;
    }
    public String getText(){
        return text;
    }
    @Override
    public void draw(Graphics g){
        g.drawText(text);
    }
    public String getType(){
        return "TextBox";
    }

}
