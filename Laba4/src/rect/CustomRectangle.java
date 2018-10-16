package rect;

import java.awt.*;

public class CustomRectangle extends Rectangle {
  Color inColor = Color.cyan;

  public CustomRectangle(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
  }

  public CustomRectangle(int dx, int dy) {
    super(dx, dy);
  }

  public void setColor(Color c) {
    this.inColor = c;
  }

  public void draw(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g2d.setStroke(dashed);
    g2d.setColor(this.inColor);
    g2d.drawRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
    g2d.dispose();
  }
}
