public class Buyer {
    private String name;
    private int money;


    public Buyer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return money;
    }

    public void setCount(int count) {
        this.money = count;
    }
}
