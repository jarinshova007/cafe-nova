import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MenuBook {
  List<Menu> menuBook = new ArrayList<>();

  ReadTextFiles textFiles = new ReadTextFiles();

  // add menu
  public void addMenu(Menu menu) {
    // adding to the arraylist
    menuBook.add(menu);

    // adding to the text file
    try {
      FileWriter writer = new FileWriter("menu_book.txt", true);
      writer.write(menu.item + " - " + menu.price + "/=\n");
      writer.close();
    } catch (IOException e) {
      System.out.println("Error saving menu.");
    }
  }

  // set menu
  public void setMenu(String oldName, String newName, String newPrice) {

    if (!textFiles.doesItemExist(oldName)) {

      System.out.println();
      System.out.println();
      System.out.println("Sorry! There is no such item in our menu.");
      System.out.println("=========================================");
      System.out.println();
      System.out.println();

      return;
    }

    try {

      Scanner fileScanner = new Scanner(new java.io.File("menu_book.txt"));

      StringBuilder newContent = new StringBuilder();

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split("\\s+-\\s+", 2);

        if (parts.length < 2) {
          newContent.append(line).append("\n");
          continue;
        }

        String item = parts[0].trim();
        String price = parts[1].replace("/=", "").trim();

        if (item.equalsIgnoreCase(oldName.trim())) {

          if (newName.trim().isEmpty()) {
            newName = item;
          }

          if (newPrice.trim().isEmpty()) {
            newPrice = price;
          }

          line = newName + " - " + newPrice + "/=";
        }

        newContent.append(line).append("\n");
      }

      fileScanner.close();

      FileWriter writer = new FileWriter("menu_book.txt");
      writer.write(newContent.toString());
      writer.close();

      System.out.println();
      System.out.println();
      System.out.println("Menu updated successfully.");
      System.out.println("=========================================");
      System.out.println();
      System.out.println();

    } catch (IOException e) {

      System.out.println("Error setting menu.");
    }
  }

  // remove menu
  public void removeMenu(String itemName) {

    if (!textFiles.doesItemExist(itemName)) {

      System.out.println();
      System.out.println();
      System.out.println("Sorry! There is no such item in our menu.");
      System.out.println("=========================================");
      System.out.println();
      System.out.println();

      return;
    }

    try {

      Scanner fileScanner = new Scanner(new java.io.File("menu_book.txt"));

      StringBuilder newContent = new StringBuilder();

      while (fileScanner.hasNextLine()) {

        String line = fileScanner.nextLine();

        String[] parts = line.split("\\s+-\\s+", 2);

        if (parts.length < 2) {
          newContent.append(line).append("\n");
          continue;
        }

        String item = parts[0].trim();

        if (item.equalsIgnoreCase(itemName.trim())) {
          continue;
        }

        newContent.append(line).append("\n");
      }

      fileScanner.close();

      FileWriter writer = new FileWriter("menu_book.txt");
      writer.write(newContent.toString());
      writer.close();

      System.out.println();
      System.out.println();
      System.out.println("Item removed successfully.");
      System.out.println("=========================================");
      System.out.println();
      System.out.println();

    } catch (IOException e) {

      System.out.println("Error removing item.");
    }
  }

  // display Menu Book
  public void displayMenuBook() {
    System.out.println("      MENU BOOK");
    System.out.println("=================================");
    System.out.println("Item            -           Pice");
    System.out.println("---------------------------------");

    // show menu method call
    textFiles.showMenu();
    System.out.println("=================================");
    System.out.println();
  }
}
