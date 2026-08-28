public class PlaceAnOrder {
    int orderNum;
    String item;
    int quantity;
    int bill;

    MenuBookkk mb = new MenuBookkk();

    ReadTextFiles file = new ReadTextFiles();

    PlaceAnOrder(int orderNum, String item, int quantity) {
        this.orderNum = orderNum;
        this.item = item;
        this.quantity = quantity;
        this.bill = file.findPrice(item) * quantity;
    }

    // see your order
    public void seeYourOrder() {
        if (file.doesItemExist(item)) {
            System.out.println();
            System.out.println();
            System.out.println("Order Number: " + this.orderNum);
            System.out.println("Item: " + this.item);
            System.out.println("Qunatity: " + this.quantity + " cup");
            System.out.println("Bill: " + bill);
            System.out.println("Order placed successfully! Please wait.");
            System.out.println("========================================");
            System.out.println();
            System.out.println();
        } else {
            System.out.println();
            System.out.println();
            System.out.println("Sorry! This item is not available in our menu.");
            System.out.println("===============================================");
            System.out.println();
            System.out.println();
        }
    }
}