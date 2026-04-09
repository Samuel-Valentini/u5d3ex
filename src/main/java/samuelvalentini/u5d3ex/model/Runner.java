package samuelvalentini.u5d3ex.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {
    private final ApplicationContext ctx;
    @Value("${order.coverCharge}")
    private double coverCharge;

    public Runner(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run(String... args) throws Exception {

        Menu menu = ctx.getBean(Menu.class);
        System.out.println(menu);
        Order order = new Order(List.of(ctx.getBean("salamiPizzaXL", Pizza.class), ctx.getBean("doubleHamPizza", Pizza.class), ctx.getBean("lemonade", Drink.class), ctx.getBean("water", Drink.class)), coverCharge, 2, OrderStatus.IN_PROGRESS, ctx.getBean("table2", Table.class));
        System.out.println(order);

    }

}
