public class Order {
    private Buyer buyer;
    private Item item;
    private int amountItems;
    private double cost;
    private static int counter;

    public Order(Buyer buyer, Item item, int amountItems, int cost) {
        this.buyer = buyer;
        this.item = item;
        this.amountItems = amountItems;
        this.cost = cost;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", item=" + item +
                ", amountItems=" + amountItems +
                '}';
    }
}
