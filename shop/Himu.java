import java.util.Scanner;

public class Himu {
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
          boolean isTryingToGetAccess = true;
          while (isTryingToGetAccess) {
            System.out.println("1 = Enter passWord and get access");
            System.out.println(" 2 = Back");
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            switch (choice) {
              case 1:
                System.out.print("enter pw: ");
                int pass = sc.nextInt();
                if (pass == pw) {
                  System.out.println("am");
                  System.out.println("jam");
                  System.out.println("kathal");
                } else {
                  System.out.println("Wrong passWord..try again");
                }
                break;
              case 2:
                isTryingToGetAccess = false;
                System.out.println("Tnx");
              default:
                System.out.println("entr valid num");
                break;
            }
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
