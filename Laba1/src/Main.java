import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    firstEx(args);
    printSeparator();
    secondEx();
    printSeparator();
    thirdEx();
    printSeparator();
    System.out.println(fourthEx(20));
    printSeparator();
    fivthEx(10000);
  }

  private static void firstEx(String[] args) {
    for (String arg : args) {
      System.out.println(arg);
    }
  }

  private static void printSeparator() {
    System.out.println("\n-------------------------------------------------------\n");
  }

  private static void secondEx() {
    for(int i = 1; i <= 500; i++) {
      if (i % 5 == 0) {
        System.out.print("fizz");
      }
      if (i % 7 == 0) {
        System.out.print("buzz");
      }
      if (i % 5 != 0 && i % 7 != 0) {
        System.out.print(i);
      }
      System.out.print('\n');
    }
  }

  private static void thirdEx() {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    for (int i = s.length() - 1; i >= 0; i--) {
      System.out.print(s.charAt(i));
    }
  }

  private static long fourthEx(long i) {
    if (i == 0) {
      return 1;
    } else {
      return i * fourthEx(i - 1);
    }
  }

  private static void fivthEx(int max) {
    boolean [] arrayOfTruth = new boolean[max + 1];
    for(int i = 2; i <= max; i++) {
      arrayOfTruth[i] = true;
    }
    //Индекс эквивалентный числу
    for(int i = 2; i <= max; i++) {
      int exceptIndex = i + i;
      while(exceptIndex <= max) {
        arrayOfTruth[exceptIndex] = false;
        exceptIndex += i;
      }
    }
    for(int i = 2; i <= max; i++) {
      if (arrayOfTruth[i]) {
        System.out.println(i);
      }
    }
  }
}