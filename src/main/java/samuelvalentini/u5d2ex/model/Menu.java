package samuelvalentini.u5d2ex.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {
    private final List<Pizza> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;

    public Menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pizzas\n");
        sb.append("-----------------------------------------------\n");
        for (Pizza pizza : pizzas) {
            sb.append(String.format("%-60s %6d %8.2f%n",
                    pizza.toString(),
                    pizza.getCalories(),
                    pizza.getPrice()));
        }

        sb.append("\nToppings\n");
        sb.append("-----------------------------------------------\n");
        for (Topping topping : toppings) {
            sb.append(String.format("%-60s %6d %8.2f%n",
                    topping.getName(),
                    topping.getCalories(),
                    topping.getPrice()));
        }

        sb.append("\nDrinks\n");
        sb.append("-----------------------------------------------\n");
        for (Drink drink : drinks) {
            sb.append(String.format("%-60s %6d %8.2f%n",
                    drink.toString(),
                    drink.getCalories(),
                    drink.getPrice()));
        }

        return sb.toString();
    }
}
