import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // password to get access
        PassWord pw = new PassWord();
        String password = pw.getPassWord();

        // read file
        ReadTextFiles read = new ReadTextFiles();

        System.out.println("========================================");
        System.out.println("              CAFÉ NOVA");
        System.out.println("========================================");
        System.out.println();

        // add coffee
        Menu m1 = new Menu("Hot Coffee", 120);
        Menu m2 = new Menu("Espresso", 150);
        Menu m3 = new Menu("Americano", 160);
        Menu m4 = new Menu("Cappuccino", 180);
        Menu m5 = new Menu("Latte", 190);
        Menu m6 = new Menu("Mocha", 220);
        Menu m7 = new Menu("Cold Coffee", 180);
        Menu m8 = new Menu("Iced Latte", 210);
        Menu m9 = new Menu("Iced Mocha", 230);
        Menu m10 = new Menu("Caramel Macchiato", 240);
        Menu m11 = new Menu("Vanilla Latte", 220);
        Menu m12 = new Menu("Hazelnut Coffee", 230);
        Menu m13 = new Menu("Irish Coffee", 250);
        Menu m14 = new Menu("Black Coffee", 130);
        Menu m15 = new Menu("Flat White", 200);
        Menu m16 = new Menu("Affogato", 260);

        MenuBookkk menuBook = new MenuBookkk();

        // menuBook.addMenu(m1);
        // menuBook.addMenu(m2);
        // menuBook.addMenu(m3);
        // menuBook.addMenu(m4);
        // menuBook.addMenu(m5);
        // menuBook.addMenu(m6);
        // menuBook.addMenu(m7);
        // menuBook.addMenu(m8);
        // menuBook.addMenu(m9);
        // menuBook.addMenu(m10);
        // menuBook.addMenu(m11);
        // menuBook.addMenu(m12);
        // menuBook.addMenu(m13);
        // menuBook.addMenu(m14);
        // menuBook.addMenu(m15);
        // menuBook.addMenu(m16);

        // generate order number
        int orderNum = 1;

        // order
        PlaceAnOrder order1 = new PlaceAnOrder(orderNum++, "Hot Coffee", 3);
        PlaceAnOrder order2 = new PlaceAnOrder(orderNum++, "Cold Coffee", 8);
        PlaceAnOrder order3 = new PlaceAnOrder(orderNum++, "Latte", 1);
        PlaceAnOrder order4 = new PlaceAnOrder(orderNum++, "Hot Coffee", 2);
        PlaceAnOrder order5 = new PlaceAnOrder(orderNum++, "Mocha", 2);
        PlaceAnOrder order6 = new PlaceAnOrder(orderNum++, "Hot Coffee", 4);
        PlaceAnOrder order7 = new PlaceAnOrder(orderNum++, "Black Coffee", 7);
        PlaceAnOrder order8 = new PlaceAnOrder(orderNum++, "Cold Coffee", 3);
        PlaceAnOrder order9 = new PlaceAnOrder(orderNum++, "Latte", 3);
        PlaceAnOrder order10 = new PlaceAnOrder(orderNum++, "Hot Coffee", 6);
        PlaceAnOrder order11 = new PlaceAnOrder(orderNum++, "Cold Coffee", 2);
        PlaceAnOrder order12 = new PlaceAnOrder(orderNum++, "Mocha", 3);
        PlaceAnOrder order13 = new PlaceAnOrder(orderNum++, "Black Coffee", 4);
        PlaceAnOrder order14 = new PlaceAnOrder(orderNum++, "Cold Coffee", 2);
        PlaceAnOrder order15 = new PlaceAnOrder(orderNum++, "Hot Coffee", 1);
        PlaceAnOrder order16 = new PlaceAnOrder(orderNum++, "Latte", 5);
        PlaceAnOrder order17 = new PlaceAnOrder(orderNum++, "Caramel Macchiato", 3);
        PlaceAnOrder order18 = new PlaceAnOrder(orderNum++, "Cold Coffee", 4);
        PlaceAnOrder order19 = new PlaceAnOrder(orderNum++, "Mocha", 2);
        PlaceAnOrder order20 = new PlaceAnOrder(orderNum++, "Latte", 5);

        AllOrder orderList = new AllOrder();
        // orderList.addOrder(order1);
        // orderList.addOrder(order2);
        // orderList.addOrder(order3);
        // orderList.addOrder(order4);
        // orderList.addOrder(order5);
        // orderList.addOrder(order6);
        // orderList.addOrder(order7);
        // orderList.addOrder(order8);
        // orderList.addOrder(order9);
        // orderList.addOrder(order10);
        // orderList.addOrder(order11);
        // orderList.addOrder(order12);
        // orderList.addOrder(order13);
        // orderList.addOrder(order14);
        // orderList.addOrder(order15);
        // orderList.addOrder(order16);
        // orderList.addOrder(order17);
        // orderList.addOrder(order18);
        // orderList.addOrder(order19);
        // orderList.addOrder(order20);

        boolean runOuterLoop = true;
        while (runOuterLoop) {
            System.out.println("1. Shopkeeper");
            System.out.println("2. Customer");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    boolean isTryingToGetAccess = true;
                    while (isTryingToGetAccess) {
                        System.out.println("1. Enter password & Get Access");
                        System.out.println("2. Back");
                        System.out.print("Choose an option: ");
                        int option = Integer.parseInt(sc.nextLine());
                        System.out.println("=================================");
                        System.out.println();

                        switch (option) {
                            case 1:
                                System.out.print("Enter the password: ");
                                String pass = sc.nextLine();
                                if (pass.equals(password)) {
                                    boolean isShopKeeper = true;
                                    while (isShopKeeper) {
                                        System.out.println("1. Add Coffee Item");
                                        System.out.println("2. Edit Coffee Item");
                                        System.out.println("3. Remove Coffee Item");
                                        System.out.println("4. View Menu");
                                        System.out.println("5. View Inventory");
                                        System.out.println("6. View Sales");
                                        System.out.println("7. View Sales Brief");
                                        System.out.println("8. View Best-Selling Coffee");
                                        System.out.println("9. View Best-Selling Ranking");
                                        System.out.println("10. Logout");

                                        System.out.print("Enter your choice: ");
                                        int ownerChoice = Integer.parseInt(sc.nextLine());

                                        switch (ownerChoice) {
                                            case 1:
                                                System.out.print("Enter item: ");
                                                String item = sc.nextLine();
                                                System.out.print("Set Price: ");
                                                int price = Integer.parseInt(sc.nextLine());

                                                Menu menu = new Menu(item, price);
                                                menuBook.addMenu(menu);
                                                break;

                                            // case 2:
                                            // System.out.print("Enter item: ");
                                            // String existingItem = sc.nextLine();
                                            // if (menuBook.doesExists(existingItem)) {
                                            // System.out.print("Set a new item: ");
                                            // String newItemName = sc.nextLine();
                                            // System.out.print("Set a new price: ");
                                            // String newPriceStr = sc.nextLine();
                                            // int newPrice;

                                            // if (newPriceStr == "") {
                                            // newPrice = -1;
                                            // } else {
                                            // newPrice = Integer.parseInt(newPriceStr);
                                            // }

                                            // menuBook.setMenu(existingItem, newItemName, newPrice);
                                            // System.out.println("Menu has been updated successfully!");
                                            // } else {
                                            // System.out.println();
                                            // System.out.println();
                                            // System.out.println("There is no such item in your menu card, Thank
                                            // you!");
                                            // System.out.println("-----------------------------------------------");
                                            // System.out.println();
                                            // System.out.println();
                                            // }
                                            // break;

                                            case 2:
                                                System.out.print("Enter item: ");
                                                String existingItem = sc.nextLine();

                                                System.out.print("Set a new item: ");
                                                String newItemName = sc.nextLine();
                                                System.out.print("Set a new price: ");
                                                String newPriceStr = sc.nextLine();
                                                menuBook.setMenu(existingItem, newItemName, newPriceStr);
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();

                                                break;

                                            // case 3:
                                            // System.out.print("Enter item: ");
                                            // String itemName = sc.nextLine();

                                            // System.out.print("Enter Price: ");
                                            // int itemPrice = Integer.parseInt(sc.nextLine());

                                            // menuBook.removeMenu(itemName, itemPrice);
                                            // break;

                                            case 4:
                                                menuBook.displayMenuBook();
                                                break;

                                            case 6:
                                                orderList.displaySell();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 8:
                                                System.out.println();
                                                System.out.println();
                                                System.out.println("=========================================");
                                                orderList.displayBestSelling();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 9:
                                                System.out.println();
                                                System.out.println();
                                                orderList.bestSellingRanking();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 10:
                                                isShopKeeper = false;
                                                System.out.println("Thank you!");
                                                break;

                                            default:
                                                System.out.println("Please enter a valid number");
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("Wrong password! Please try again...");
                                    System.out.println("===================================");
                                    System.out.println();
                                    System.out.println();
                                }
                                break;

                            case 2:
                                isTryingToGetAccess = false;
                                System.out.println("=================================");
                                System.out.println();
                                break;

                            default:
                                System.out.println("Please enter a valid integer number!");
                                System.out.println("====================================");
                                System.out.println();
                                break;
                        }
                    } // end

                    break;

                case 2:
                    boolean isCustomer = true;
                    while (isCustomer) {
                        System.out.println("1. View Menu");
                        System.out.println("2. Place Order");
                        System.out.println("3. View Best-Selling Ranking");
                        System.out.println("4. Exit");
                        System.out.print("choose an option: ");
                        int customerChoice = Integer.parseInt(sc.nextLine());

                        switch (customerChoice) {
                            case 1:
                                menuBook.displayMenuBook();
                                break;

                            case 2:

                                System.out.print("Enter the item name(Please enter the correct spelling): ");
                                String item = sc.nextLine();
                                System.out.print("Enter the quantity: ");
                                int quantity = Integer.parseInt(sc.nextLine());

                                // place order
                                PlaceAnOrder order = new PlaceAnOrder(orderNum++, item, quantity);
                                order.seeYourOrder();
                                // add order
                                orderList.addOrder(order);
                                break;

                            case 3:
                                System.out.println();
                                System.out.println();
                                orderList.bestSellingRanking();
                                System.out.println("=========================================");
                                System.out.println();
                                System.out.println();
                                break;

                            case 4:
                                isCustomer = false;
                                System.out.println();
                                System.out.println();

                                System.out.println("Thanks for using our app!");
                                System.out.println("=================================");
                                System.out.println();
                                System.out.println();
                                break;

                            case 6:
                                orderList.displaySell();
                                break;

                            default:
                                System.out.println("enter a valid digit");
                                break;
                        }
                    }
                    break;

                case 3: {
                    System.out.println("Thank you!");
                    runOuterLoop = false;
                    break;
                }

                default:
                    System.out.println("please enter a valid number!");
                    break;
            }
        }

        sc.close();

    }
}