import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import rect.ColoredRect;
import rect.CustomRectangle;
import rect.DrawableRect;
import rect.Rectangle;

public class Testtes extends Applet implements ActionListener, MouseListener, MouseMotionListener {
  Button rectButton = new Button("Прямоугольник 1");
  Button drawableRectButton = new Button("Прямоугольник 2");
  Button coloredRectButton = new Button("Прямоугольник 3");
  List<Rectangle> rects = new ArrayList<Rectangle>();
  Rectangle selectedRect;
  Point lastCursorPoint;

  public void init() {
    rectButton.setName("rect");
    rectButton.addActionListener(this);
    this.add(rectButton);
    this.add(drawableRectButton);
    drawableRectButton.setName("drawableRect");
    drawableRectButton.addActionListener(this);
    this.add(coloredRectButton);
    coloredRectButton.setName("coloredRect");
    coloredRectButton.addActionListener(this);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
  }

  public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    selectedRect = getSelectedRect(x, y);
    lastCursorPoint = new Point(x, y);
  }

  public Rectangle getSelectedRect(int x, int y) {
    for(Rectangle r: rects) {
      if (r.x1 <= x && r.x2 >= x && r.y1 <= y && r.y2 >= y) {
        return r;
      }
    }
    return null;
  }

  public void mouseReleased(MouseEvent e) {
    if(selectedRect != null) {
      int rectIndex = rects.indexOf(selectedRect);
      rects.remove(rectIndex);
      rects.add(0, selectedRect);
    }
    selectedRect = null;
    lastCursorPoint = null;
  }

  public void mouseDragged(MouseEvent e) {
    if (selectedRect == null) {
      return;
    }
    int currentX = e.getX();
    int currentY = e.getY();
    int dx = currentX - lastCursorPoint.x;
    int dy = currentY - lastCursorPoint.y;
    selectedRect.move(dx, dy);
    repaintRects();
    lastCursorPoint = new Point(currentX, currentY);
  }

  public void mouseMoved(MouseEvent e) {;}
  public void mouseClicked(MouseEvent e) {;}
  public void mouseEntered(MouseEvent e) {;}
  public void mouseExited(MouseEvent e) {;}

  public void actionPerformed(ActionEvent e) {
    Rectangle r = new Rectangle(200, 200);
    switch (((Button)e.getSource()).getName()) {
      case "drawableRect":
        r = new DrawableRect(200, 200);
        r.setColor(Color.blue);
        break;
      case "coloredRect":
        r = new ColoredRect(200, 200);
        r.setColor(Color.red);
        break;
      case "rect":
//        r = new ColoredRect(200, 200);
//        r.setColor(Color.cyan);
        r = new CustomRectangle(200, 200);
        break;
    }
    r.draw(this.getGraphics());
    rects.add(0, r);
  }



  void repaintRects() {
    Graphics g = this.getGraphics();
    Dimension d = this.getSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, d.width, d.height);
    for(Rectangle r : this.rects) {
      r.draw(g);
    }
  }
}