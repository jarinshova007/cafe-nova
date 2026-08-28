public class PlaceAnOrder {
    int orderNum;
    String item;
    int quantity;
    int bill;

    MenuBook mb = new MenuBook();
    ReadTextFiles file = new ReadTextFiles();

    PlaceAnOrder(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.bill = file.findPrice(item) * quantity;
    }

    // see your order
    public void seeYourOrder() {
        if (file.doesItemExist(item)) {
            System.out.println();
            System.out.println();
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