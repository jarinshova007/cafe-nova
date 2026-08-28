import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadTextFiles {
  public static int genNewNum() {

    File file = new File("order_number.txt");

    int newNumber = 1;

    try {

      if (file.exists() && file.length() > 0) {

        Scanner scanner = new Scanner(file);

        int lastNumber = scanner.nextInt();

        scanner.close();

        newNumber = lastNumber + 1;
      }

      FileWriter writer = new FileWriter(file, false);
      writer.write(String.valueOf(newNumber));
      writer.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return newNumber;
  }

  // show menu
  public void showMenu() {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("menu_book.txt"));

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine().trim();

        // skip empty line
        if (line.isEmpty()) {
          continue;
        }

        String[] parts = line.split("\\s+-\\s+", 2);

        // skip invalid line
        if (parts.length < 2) {
          continue;
        }

        String item = parts[0].trim();
        String price = parts[1].trim();

        System.out.printf("%-25s - %s%n", item, price);
      }

      fileScanner.close();

    } catch (FileNotFoundException e) {

      System.out.println("Menu file not found.");
    }
  }

  // find price
  public int findPrice(String item) {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("menu_book.txt"));

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split(" - ");

        if (parts.length < 2) {
          continue;
        }

        String menuItem = parts[0].trim();

        if (menuItem.equalsIgnoreCase(item)) {

          int price = Integer.parseInt(
              parts[1].replace("/=", "").trim());

          fileScanner.close();

          return price;
        }
      }

      fileScanner.close();

    } catch (FileNotFoundException e) {

      System.out.println("Menu file not found.");

    }

    return 0;
  }

  // does item exist
  public boolean doesItemExist(String item) {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("menu_book.txt"));

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine().trim();

        // skip empty line
        if (line.isEmpty()) {
          continue;
        }

        String[] parts = line.split("\\s+-\\s+", 2);

        // skip if there's no "-"
        if (parts.length < 2) {
          continue;
        }

        String menuItem = parts[0].trim();

        if (menuItem.equalsIgnoreCase(item.trim())) {

          fileScanner.close();
          return true;
        }
      }

      fileScanner.close();
      return false;

    } catch (FileNotFoundException e) {

      System.out.println("Menu file not found.");
      return false;
    }
  }

  // view sell
  public void viewSell() {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("all_order.txt"));

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split("     -     ");

        String item = parts[0];
        String quantity = parts[1];
        String bill = parts[2];

        System.out.printf("%-25s %-10s %s%n", item, quantity, bill);
      }

      fileScanner.close();

    } catch (FileNotFoundException e) {
      System.out.println("Sale file not found.");
    }
  }

  // best selling item
  public void bestSellingItem() {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("all_order.txt"));

      HashMap<String, Integer> sales = new HashMap<>();

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split("\\s+-\\s+");

        String item = parts[0];
        int quantity = Integer.parseInt(parts[1].trim());

        sales.put(item, sales.getOrDefault(item, 0) + quantity);
      }

      fileScanner.close();

      String bestItem = "";
      int maxQuantity = 0;

      for (String item : sales.keySet()) {

        if (sales.get(item) > maxQuantity) {
          maxQuantity = sales.get(item);
          bestItem = item;
        }
      }

      System.out.println("Best Selling Item : " + bestItem);
      System.out.println("Total Sold        : " + maxQuantity);

    } catch (FileNotFoundException e) {

      System.out.println("Sale file not found.");

    }
  }

  public void bestSellingRanking() {

    try {

      Scanner fileScanner = new Scanner(new java.io.File("all_order.txt"));

      HashMap<String, Integer> sales = new HashMap<>();

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split("\\s+-\\s+");

        String item = parts[0].trim();
        int quantity = Integer.parseInt(parts[1].trim());

        sales.put(item, sales.getOrDefault(item, 0) + quantity);
      }

      fileScanner.close();

      List<Map.Entry<String, Integer>> ranking = new ArrayList<>(sales.entrySet());

      ranking.sort(
          Map.Entry.comparingByValue(Comparator.reverseOrder()));

      System.out.println("\n========== BEST SELLING RANKING ==========\n");

      int rank = 1;

      for (Map.Entry<String, Integer> entry : ranking) {

        System.out.println(rank + ". " + entry.getKey());

        rank++;

        if (rank > 5) {
          break;
        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("Sale file not found.");
    }
  }
}