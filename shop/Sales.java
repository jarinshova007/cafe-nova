public class Sales {
  String item;
  int quantity;
  int totalBill;

  ReadTextFiles file = new ReadTextFiles();

  Sales(String item, int quantity) {
    this.item = item;
    this.quantity = quantity;
    this.totalBill = file.findPrice(item) * quantity;
  }

}
