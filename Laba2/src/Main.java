import rect.Rectangle;

public class Main {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(5, 5);
    System.out.println(r1);
    r1.move(2, 3);
    System.out.println(r1);
    Rectangle r2 = new Rectangle(5, 5);
    Rectangle r3 = r2.Union(r1);
    System.out.println(r3);
  }
}
