import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Shampoo", 120, Item.CategoryItems.HOUSEHOLD_CHEMICALS));
        items.add(new Item("Toothpaste", 90, Item.CategoryItems.HOUSEHOLD_CHEMICALS));
        items.add(new Item("Banana", 75, Item.CategoryItems.FOOD));
        items.add(new Item("Apple", 50, Item.CategoryItems.FOOD));
        items.add(new Item("Potato", 60, Item.CategoryItems.FOOD));

        ArrayList<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer("Ilia", 1000));
        buyers.add(new Buyer("Sabina", 5000));

        Shop shop = new Shop(items, buyers);
        try {
            shop.deal("Ilia", "Shampoo", 1, 120);
            shop.showItems();
            System.out.println();

            shop.setDiscountCategory(Item.CategoryItems.FOOD);
            shop.showItems();
            System.out.println();

            shop.setDiscountCategory(Item.CategoryItems.HOUSEHOLD_CHEMICALS);
            shop.showItems();
            System.out.println();
        } catch (NoBuyerFoundException e) {
            e.printStackTrace();
        } catch (NoItemFoundException e) {
            e.printStackTrace();
        } catch (IllegalAmountException e) {
            e.printStackTrace();
        } catch (TooMuchSaleException e) {
            e.printStackTrace();
        }

        System.out.println("-------------");
        System.out.println("Total deals: " + Order.getCounter());
    }
}