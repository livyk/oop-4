import java.applet.Applet;
import java.awt.*;
import rect.DrawableRect;
import rect.ColoredRect;

public class TestApplet extends Applet {
  public void paint(Graphics g) {
    DrawableRect r1 = new DrawableRect(50, 50);
    r1.move(75, 75);
    r1.setColor(Color.red);
    r1.draw(g);
    DrawableRect r2 = new DrawableRect(50, 50);
    rect.Rectangle r3 = r1.Union(r2);
    ColoredRect dr3 = new ColoredRect(r3.x1, r3.y1, r3.x2, r3.y2);
    r2.draw(g);
    dr3.setColor(Color.blue);
    dr3.draw(g);
  }
}
