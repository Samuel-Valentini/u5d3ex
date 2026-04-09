package samuelvalentini.u5d2ex.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends MenuItem {
    private static final double MARGHERITA_PRICE = 4.99;
    private static final int MARGHERITA_CALORIES = 1104;

    private final List<Topping> toppings;
    private final PizzaSize size;

    public Pizza(String name, List<Topping> toppings) {
        this(name, toppings, PizzaSize.STANDARD);
    }

    public Pizza(String name, List<Topping> toppings, PizzaSize size) {
        this.name = name;
        this.toppings = new ArrayList<>(toppings);
        this.size = size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public PizzaSize getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        double toppingsPrice = toppings.stream()
                .mapToDouble(Topping::getPrice)
                .sum();

        return (MARGHERITA_PRICE + toppingsPrice) * size.getPriceMultiplier();
    }

    @Override
    public int getCalories() {
        int toppingsCalories = toppings.stream()
                .mapToInt(Topping::getCalories)
                .sum();

        return (int) Math.round((MARGHERITA_CALORIES + toppingsCalories) * size.getCaloriesMultiplier());
    }

    public String getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("tomato");
        ingredients.add("cheese");
        ingredients.addAll(
                toppings.stream()
                        .map(Topping::getName)
                        .collect(Collectors.toList())
        );

        return String.join(", ", ingredients);
    }

    @Override
    public String toString() {
        String sizeLabel = size == PizzaSize.XL ? " XL" : "";
        return name + sizeLabel + " (" + getIngredients() + ")";
    }
}
