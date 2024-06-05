package org.example;

public class RightArrow implements Shape {
    @Override
    public void draw(Graphics g) {
        g.drawText( " \\ " );
        g.drawText( "-----" );
        g.drawText( " / " );
    }
}