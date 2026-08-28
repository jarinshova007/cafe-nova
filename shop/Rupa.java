import java.util.Scanner;

public class Rupa {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean isOuter = true;
    while (isOuter) {
      System.out.println("opn 1");
      System.out.println("opn 2");
      System.out.println("Exit");
      System.out.print("Enter 1 or 2 or 3: ");
      int opn = sc.nextInt();
      int pw = 123;
      switch (opn) {
        case 1:
          System.out.print("Enter pw: ");
          int pass = sc.nextInt();
          if (pass == pw) {
            System.out.println("La La La");
          } else {
            System.out.println("Wrong pw");
          }
          break;

        case 2:
          System.out.println("B successfull");
          break;

        case 3:
          isOuter = false;
          System.out.println("Thanks outer");
          break;

        default:
          System.out.println("Enter a valid opn");
          break;
      }
    }
  }
}
