import java.util.ArrayList;
import java.util.Random;

public class Shop {

    private static ArrayList<Item> stock;
    private static ArrayList<Buyer> customers;
    private static double totalDiscount;

    public Shop(ArrayList<Item> stock, ArrayList<Buyer> customers) {
        this.stock = stock;
        this.customers = customers;
    }

    public static ArrayList<Item> getStock() {
        return stock;
    }

    public static void setStock(ArrayList<Item> stock) {
        Shop.stock = stock;
    }

    public static ArrayList<Buyer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Buyer> customers) {
        Shop.customers = customers;
    }

    public Order deal(String buyerName, String item, int amount, int cost) throws NoBuyerFoundException, NoItemFoundException, IllegalAmountException {

        if (amount <= 0) {
            throw new IllegalAmountException("Amount is: " + amount + "\nExpected > 0");
        }
        Buyer tempBuyer = null;
        Item tempItem = null;

        for (int i = 0; i < customers.size(); i++) {
            if (buyerName.equals(customers.get(i).getName())) {
                tempBuyer = customers.get(i);
                break;
            }
        }
        if (tempBuyer == null) {
            throw new NoBuyerFoundException("No such Buyer found");
        }
        for (int i = 0; i < stock.size(); i++) {
            if (item.equals(stock.get(i).getName())) {
                tempItem = stock.get(i);
                break;
            }
        }
        if (tempItem == null) {
            throw new NoItemFoundException("Shop doesn't have " + item);
        }
        return new Order(tempBuyer, tempItem, amount, cost);
    }

    /*
   Написать метод, при вызове которого на переданную категорию товара назначается рандомная скидка из перечисления.
   */
    public void setDiscountCategory(Item.CategoryItems categoryItems) throws TooMuchSaleException {
        int randomChose = new Random().nextInt(Item.Discount.values().length);
        Item.Discount newDiscount = Item.Discount.values()[randomChose];
        for (int i = 0; i < stock.size(); i++) {
            if (categoryItems.equals(stock.get(i).getCategoryItems())) {
                stock.get(i).setDiscount(newDiscount);
                stock.get(i).setPrice(stock.get(i).getPrice() - (stock.get(i).getPrice() * stock.get(i).getDiscount().getDiscountEnum()));
                this.totalDiscount += stock.get(i).getDiscount().getDiscountEnum() * 100;  // Если сумма величин скидок на товары из заказа получилась больше 50%, выбросить исключение TooMuchSaleException()
            }
        }
        System.out.println("Скидка " + newDiscount.getDiscountEnum() * 100 + "%. Установлена для категории товаров: " +
                categoryItems.getCategory() + "\n");
        if (totalDiscount > 50) {
            throw new TooMuchSaleException("Величина скидки превышает 50%");
        }
    }

    public void showItems() {
        for (int i = 0; i < stock.size(); i++) {
            System.out.println("Название товара: " + stock.get(i).getName() +
                    ", категория: " + stock.get(i).getCategoryItems().getCategory() +
                    ", цена: " + stock.get(i).getPrice() + ", размер скидки: " +
                    stock.get(i).getDiscount().getDiscountEnum() * 100 + "%.");
        }
    }
}
