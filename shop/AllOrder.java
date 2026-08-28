
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AllOrder {
    List<PlaceAnOrder> orderList = new ArrayList<>();

    // add order
    public void addOrder(PlaceAnOrder order) {
        orderList.add(order);

        // adding to the text file
        try {
            FileWriter writer = new FileWriter("all_order.txt", true);
            writer.write(order.item + "     -     " + order.quantity + "      -     " + order.bill + "/=\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving menu.");
        }
    }

    ReadTextFiles textFiles = new ReadTextFiles();

    // display sell
    public void displaySell() {
        System.out.println("Ordered Coffee Item    Quantity      Bill");
        System.out.println("--------------------------------------------------------------");
        textFiles.viewSell();
        System.out.println();
    }

    // display bestselling item
    public void displayBestSelling() {
        textFiles.bestSellingItem();
    }

    // display best selling ranking
    public void bestSellingRanking() {
        textFiles.bestSellingRanking();
    }
}
