package samuelvalentini.u5d3ex;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import samuelvalentini.u5d3ex.model.*;

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

    @Test
    void pizzaSizeTester() {
        Pizza pizza1 = new Pizza("testPizza", List.of());
        Pizza pizza2 = new Pizza("testPizzaXL", List.of(), PizzaSize.XL);

        assertEquals((int) Math.round(pizza1.getCalories() * 1.95), pizza2.getCalories());
        assertEquals(pizza1.getPrice() * 1.4, pizza2.getPrice());

    }

    @Test
    void orderStatusChanger() {
        Order order = new Order(List.of(ctx.getBean("hawaiianPizza", Pizza.class)), coverCharge, 1, OrderStatus.IN_PROGRESS, ctx.getBean("table1", Table.class));
        order.setOrderStatus(OrderStatus.READY);
        assertEquals(OrderStatus.READY, order.getOrderStatus());
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        assertEquals(OrderStatus.IN_PROGRESS, order.getOrderStatus());
        order.setOrderStatus(OrderStatus.SERVED);
        assertEquals(OrderStatus.SERVED, order.getOrderStatus());
    }


}
