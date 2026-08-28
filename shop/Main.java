import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // password to get access
        PassWord pw = new PassWord();
        String password = pw.getPassWord();

        MenuBook menuBook = new MenuBook();
        AllOrder orderList = new AllOrder();

        System.out.println("========================================");
        System.out.println("              CAFÉ NOVA");
        System.out.println("========================================");
        System.out.println();

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
                                    System.out.println("Login Successful!");
                                    System.out.println();
                                    System.out.println();

                                    boolean isShopKeeper = true;
                                    while (isShopKeeper) {
                                        System.out.println("1. Add Coffee Item");
                                        System.out.println("2. Edit Coffee Item");
                                        System.out.println("3. Remove Coffee Item");
                                        System.out.println("4. View Menu");
                                        System.out.println("5. View Inventory");
                                        System.out.println("6. View Sales");
                                        System.out.println("7. View Best-Selling Coffee");
                                        System.out.println("8. View Best-Selling Ranking");
                                        System.out.println("9. Logout");

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

                                            case 3:
                                                System.out.print("Enter item: ");
                                                String itemName = sc.nextLine();

                                                menuBook.removeMenu(itemName);
                                                break;

                                            case 4:
                                                menuBook.displayMenuBook();
                                                break;

                                            case 5:
                                                System.out.println();
                                                System.out.println();
                                                System.out.println("Sorry! Inventory feature is not available yet.");
                                                System.out.println("It will be added in the final version.");
                                                System.out.println("=========================================");
                                                System.out.println();
                                                break;

                                            case 6:
                                                orderList.displaySell();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 7:
                                                System.out.println();
                                                System.out.println();
                                                System.out.println("=========================================");
                                                orderList.displayBestSelling();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 8:
                                                System.out.println();
                                                System.out.println();
                                                orderList.bestSellingRanking();
                                                System.out.println("=========================================");
                                                System.out.println();
                                                System.out.println();
                                                break;

                                            case 9:
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
                                PlaceAnOrder order = new PlaceAnOrder(item, quantity);
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
                    System.out.println("---------------------------");
                    System.out.println("Thanks for using our app!");
                    System.out.println("---------------------------");
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