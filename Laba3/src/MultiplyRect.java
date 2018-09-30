import java.applet.Applet;
import java.awt.*;
import java.util.Random;

import rect.ColoredRect;
import rect.DrawableRect;
import rect.Rectangle;

/** An applet that displays a simple animation */
public class MultiplyRect extends Applet implements Runnable {
  Color [] colors = {
          Color.red, Color.black, Color.gray, Color.green, Color.yellow,
          Color.magenta, Color.pink, Color.orange, Color.cyan, Color.lightGray
  };
  Random rand = new Random();
  Point [] vectors = new Point[20];
  Thread animator; // The thread that performs the animation

  volatile boolean pleaseStop; // A flag to ask the thread to stop
  Rectangle[] rects = new Rectangle[20];
  public void initRects() {
    for(int i = 0; i < colors.length; i++) {
      DrawableRect r = new DrawableRect(50, 50);
      r.setColor(colors[i]);
      r.move(rand.nextInt(250), rand.nextInt(250));
      rects[i] = r;
      vectors[i] = new Point((rand.nextInt(4) + 1),(rand.nextInt(4) + 1));
    }
    for(int i = 0; i < colors.length; i++) {
      ColoredRect r = new ColoredRect(50, 50);
      r.setColor(colors[i]);
      r.move(rand.nextInt(250), rand.nextInt(250));
      rects[i + 10] = r;
      vectors[i + 10] = new Point((rand.nextInt(4) + 1),(rand.nextInt(4) + 1));
    }
  }
  /** This method simply draws the circle at its current position */
  public void paint(Graphics g) {
    for(Rectangle r : rects) {
      r.draw(g);
    }
  }

  /**
   * This method moves (and bounces) the circle and then requests a redraw.
   * The animator thread calls this method periodically.
   */
  public void animate() {
    // Bounce if we've hit an edge.
    java.awt.Rectangle bounds = getBounds();
    for(int i = 0; i < rects.length; i++) {
      Rectangle r1 = rects[i];
      Point vector = vectors[i];
      if ((r1.x1 + vector.x < 0) || r1.x2 + vector.x > bounds.width) {
        vector.x = -vector.x;
      }
      if ((r1.y1 + vector.y < 0) || r1.y2 + vector.y > bounds.height) {
        vector.y = -vector.y;
      }
      // Move the circle.
      r1.move(vector.x, vector.y);
    }
    // Ask the browser to call our paint() method to draw the circle
    // at its new position.
    repaint();
  }

  /**
   * This method is from the Runnable interface. It is the body of the thread
   * that performs the animation. The thread itself is created and started in
   * the start() method.
   */
  public void run() {
    initRects();
    while (!pleaseStop) { // Loop until we're asked to stop
      animate(); // Update and request redraw
      try {
        Thread.sleep(30);
      } // Wait 100 milliseconds
      catch (InterruptedException e) {
      } // Ignore interruptions
    }
  }

  /** Start animating when the browser starts the applet */
  public void start() {
    animator = new Thread(this); // Create a thread
    pleaseStop = false; // Don't ask it to stop now
    animator.start(); // Start the thread.
    // The thread that called start now returns to its caller.
    // Meanwhile, the new animator thread has called the run() method
  }

  /** Stop animating when the browser stops the applet */
  public void stop() {
    // Set the flag that causes the run() method to end
    pleaseStop = true;
  }
}