package samuelvalentini.u5d3ex.model;

public class Topping extends MenuItem {
    private final double price;
    private final int calories;

    public Topping(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }


    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name;
    }
}
