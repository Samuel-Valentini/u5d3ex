package samuelvalentini.u5d3ex;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import samuelvalentini.u5d3ex.model.Order;
import samuelvalentini.u5d3ex.model.OrderStatus;
import samuelvalentini.u5d3ex.model.Pizza;
import samuelvalentini.u5d3ex.model.Table;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class U5D3ExApplicationTests {
    private final ApplicationContext ctx;
    @Value("${order.coverCharge}")
    private double coverCharge;

    public U5D3ExApplicationTests(ApplicationContext ctx) {
        this.ctx = ctx;
    }


    @Test
    @org.junit.jupiter.api.Order(1)
    void contextLoads() {
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void orderPriceChecker() {
        Order order = new Order(List.of(ctx.getBean("hawaiianPizza", Pizza.class)), coverCharge, 1, OrderStatus.IN_PROGRESS, ctx.getBean("table1", Table.class));
        assertEquals(8.27, order.getTotalAmount());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void orderPriceMultiplePizzasChecker() {
        Order order = new Order(List.of(ctx.getBean("hawaiianPizza", Pizza.class), ctx.getBean("salamiPizza", Pizza.class)), coverCharge, 1, OrderStatus.IN_PROGRESS, ctx.getBean("table1", Table.class));
        assertEquals(14.25, order.getTotalAmount());
    }

}
