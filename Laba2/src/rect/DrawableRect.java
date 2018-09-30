package rect;

import java.awt.*;

public class DrawableRect extends Rectangle {
  Color outColor = Color.black;

  DrawableRect(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
  }

  DrawableRect(int dx, int dy) {
    super(dx, dy);
  }

  public void draw(Graphics g) {
    g.setColor(this.outColor);
    g.drawRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
  }
  public void setColor(Color c) {
    this.outColor = c;
  }
}
