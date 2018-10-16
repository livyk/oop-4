package rect;

import java.awt.*;

public class Rectangle {
  public int x1, y1, x2, y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }

  public Rectangle(int dx, int dy) {
    this.x1 = 0;
    this.x2 = dx;
    this.y1 = 0;
    this.y2 = dy;
  }

  public void rectPrint() {
    System.out.println(String.format("(%d, %d); (%d, %d)", this.x1, this.y1, this.x2, this.y2));
  }

  public void move(int dx, int dy) {
    this.x1 += dx;
    this.x2 += dx;
    this.y1 += dy;
    this.y2 += dy;
  }

  public static Rectangle Union(Rectangle r1, Rectangle r2) {
    int x1 = r1.x1 > r2.x1 ? r1.x1 : r2.x1;
    int x2 = r1.x2 < r2.x2 ? r1.x2 : r2.x2;
    int y1 = r1.y1 > r2.y1 ? r1.y1 : r2.y1;
    int y2 = r1.y2 < r2.y2 ? r1.y2 : r2.y2;
    return new Rectangle(x1, y1, x2, y2);
  }

  public void draw(Graphics g) {

  }

  public void setColor(Color c) {

  }

  public Rectangle Union(Rectangle r) {
    return Rectangle.Union(this, r);
  }

  @Override
  public String toString() {
    return String.format("x1 = %d, y1 = %d; x2 = %d, y2 = %d", this.x1, this.y1, this.x2, this.y2);
  }
}
