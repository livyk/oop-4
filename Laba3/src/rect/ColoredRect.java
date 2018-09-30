package rect;

import java.awt.*;

public class ColoredRect extends DrawableRect {
  Color inColor = Color.black;

  public ColoredRect(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
  }

  public ColoredRect(int dx, int dy) {
    super(dx, dy);
  }

  @Override
  public void setColor(Color c) {
    this.inColor = c;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(this.inColor);
    g.fillRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
  }
}
