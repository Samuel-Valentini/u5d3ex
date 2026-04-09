package samuelvalentini.u5d2ex.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import samuelvalentini.u5d2ex.model.*;

import java.util.List;

@Configuration
public class MenuConfig {

    @Bean
    public Topping cheese() {
        return new Topping("cheese", 0.69, 92);
    }

    @Bean
    public Topping blueCheese() {
        return new Topping("blue-cheese", 1.2, 122);
    }

    @Bean
    public Topping ham() {
        return new Topping("ham", 0.99, 35);
    }

    @Bean
    public Topping onions() {
        return new Topping("onions", 0.69, 22);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("pineapple", 0.79, 24);
    }

    @Bean
    public Topping salami() {
        return new Topping("salami", 0.99, 86);
    }

    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", "0.33l", 1.29, 128);
    }

    @Bean
    public Drink water() {
        return new Drink("Water", "0.5l", 1.29, 0);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", "0.75l, 13%", 7.49, 607);
    }

    @Bean
    public Pizza margherita() {
        return new Pizza("Pizza Margherita", List.of());
    }

    @Bean
    public Pizza hawaiianPizza(
            @Qualifier("ham") Topping ham,
            @Qualifier("pineapple") Topping pineapple
    ) {
        return new Pizza("Hawaiian Pizza", List.of(ham, pineapple));
    }

    @Bean
    public Pizza salamiPizza(
            @Qualifier("salami") Topping salami
    ) {
        return new Pizza("Salami Pizza", List.of(salami));
    }

    @Bean
    public Pizza doubleHamPizza(
            @Qualifier("ham") Topping ham
    ) {
        return new Pizza("Margherita + double ham", List.of(ham, ham));
    }

    @Bean
    public Pizza hawaiianPizzaXl(
            @Qualifier("ham") Topping ham,
            @Qualifier("pineapple") Topping pineapple
    ) {
        return new Pizza("Hawaiian Pizza", List.of(ham, pineapple), PizzaSize.XL);
    }

    @Bean
    public Pizza salamiPizzaXL(
            @Qualifier("salami") Topping salami
    ) {
        return new Pizza("Salami Pizza", List.of(salami), PizzaSize.XL);
    }


//    @Bean
//    public Menu menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
//        return new Menu(pizzas, toppings, drinks);
//    }

    @Bean
    public Table table1() {
        Table table = new Table(1, 20);
        table.setOccupied(false);
        return table;
    }

    @Bean
    public Table table2() {
        Table table = new Table(2, 5);
        table.setOccupied(false);
        return table;
    }


    @Bean
    public Table table3() {
        Table table = new Table(3, 25);
        table.setOccupied(false);
        return table;
    }

    @Bean
    public List<Table> tablesList(List<Table> tablesList) {
        return tablesList;
    }


}
