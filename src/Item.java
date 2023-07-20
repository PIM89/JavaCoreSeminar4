public class Item {

    private String name;
    private double price;
    /*
    Добавить в Товар поле категория со значением созданного перечисления. Добавить геттеры, сеттеры.
     */
    private CategoryItems categoryItems;
    private Discount discount;

    /*
    В класс Товаров добавить перечисление с категориями товаров.
     */
    enum CategoryItems {
        FOOD("Еда"),
        APPLIANCES("Бытовая техника"),
        ELECTRONICS("Електроника"),
        CLOTHES("Одежда"),
        HOUSEHOLD_CHEMICALS("Бытовая химия");

        private String category;

        CategoryItems(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }
    }

    /*
    Добавить перечисление с размерами скидок - 0, 5, 10, 15, 20%.
     */
    enum Discount {
        ZERO(0), FIVE(0.05), TEN(0.1), FIFTEEN(0.15), TWENTY(0.2);
        private double discount;

        Discount(double discount) {
            this.discount = discount;
        }

        public double getDiscountEnum() {
            return discount;
        }
    }

    public Item(String name, int price, CategoryItems categoryItems) {
        this.name = name;
        this.price = price;
        this.categoryItems = categoryItems;
        this.discount = Discount.ZERO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryItems getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(CategoryItems categoryItems) {
        this.categoryItems = categoryItems;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
