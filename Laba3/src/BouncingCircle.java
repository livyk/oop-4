import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import rect.ColoredRect;

/** An applet that displays a simple animation */
public class BouncingCircle extends Applet implements Runnable {
  int dx = 2, dy = 2;
  Thread animator; // The thread that performs the animation
  ColoredRect r1 = new ColoredRect(100, 100);
  volatile boolean pleaseStop; // A flag to ask the thread to stop

  /** This method simply draws the circle at its current position */
  public void paint(Graphics g) {
    r1.setColor(Color.red);
    r1.draw(g);
  }

  /**
   * This method moves (and bounces) the circle and then requests a redraw.
   * The animator thread calls this method periodically.
   */
  public void animate() {
    // Bounce if we've hit an edge.
    Rectangle bounds = getBounds();
    if ((r1.x1 + dx < 0) || r1.x2 + dx > bounds.width) {
      dx = -dx;
    }
    if ((r1.y1 + dx < 0) || r1.y2 + dx > bounds.height) {
      dy = -dy;
    }
    // Move the circle.
    r1.move(dx, dy);

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