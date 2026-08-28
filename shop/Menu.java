public class Menu {
    String item;
    int price;

    Menu(String item, int price) {
        this.item = item;
        this.price = price;
    }

    // get item
    public String getItem() {
        return item;
    }

    // get price
    public int getPrice() {
        return price;
    }
}
