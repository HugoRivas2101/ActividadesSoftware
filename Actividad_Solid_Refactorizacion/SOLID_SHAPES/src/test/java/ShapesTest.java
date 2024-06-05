import org.example.Graphics;
import org.example.Rectangle;
import org.junit.jupiter.api.Test;

public class ShapesTest {

    Graphics g=new Graphics();

    @Test
    void drawRectangleTest(){
        Rectangle r=new Rectangle(2,3);
        r.draw(g);
    }
}
