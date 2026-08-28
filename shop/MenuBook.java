import java.util.List;
import java.util.ArrayList;

public class MenuBook {
    static List<Menu> menuBook = new ArrayList<>();

    // add menu
    public void addMenu(Menu menu) {
        // adding to the arraylist
        menuBook.add(menu);
    }

    // does Exists
    public boolean doesExists(String item) {
        for (Menu menu : menuBook) {
            if (item.equals(menu.item)) {
                return true;
            }
        }
        return false;
    }

    // set Menu
    public void setMenu(String oldItem, String newItem, int newPrice) {
        for (Menu menu : menuBook) {
            if (menu.item.equals(oldItem)) {
                if (newItem == "") {
                    menu.item = menu.item;
                } else {
                    menu.item = newItem;
                }

                if (newPrice <= 0) {
                    menu.price = menu.price;
                } else {
                    menu.price = newPrice;
                }
            }
        }
    }

    // remove menu
    public void removeMenu(String item, int price) {

        if (!doesExists(item)) {
            System.out.println();
            System.out.println();
            System.out.println("There is no such item in your menu card, Thank you!");
            System.out.println("-----------------------------------------------");
            System.out.println();
            System.out.println();
        } else {
            Menu m = new Menu(item, price);
            menuBook.remove(m);
            System.out.println(item + " has been successfully removed from your menu card");
            return;
        }
    }

    public int getPrice(String item) {
        int price = 0;
        for (Menu menu : menuBook) {
            if (menu.item.equals(item)) {
                price = menu.price;
            }
        }
        return price;
    }

    // showMenuBook
    public void displayMenuBook() {
        System.out.println("              MENU BOOK");
        System.out.println("      =============================");
        System.out.println("        item       -       price");
        System.out.println("      -----------------------------");
        for (Menu m : menuBook) {
            if (m.item.length() == 8) {
                System.out.println("       " + m.item + "         " + m.price);
            }
            if (m.item.length() == 14) {
                System.out.println("       " + m.item + "    " + m.price);
            }
            if (m.item.length() >= 6) {
                System.out.println("       " + m.item + "          " + m.price);
            } else {
                System.out.println("       " + m.item + "               " + m.price);
            }
        }
        System.out.println("      =============================");
        System.out.println();
    }
}
