package samuelvalentini.u5d3ex.model;

public class Drink extends MenuItem {
    private final String description;
    private final double price;
    private final int calories;

    public Drink(String name, String description, double price, int calories) {
        this.name = name;
        this.description = description;
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
        return name + " (" + description + ")";
    }
}
