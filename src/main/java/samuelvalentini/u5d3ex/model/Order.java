package samuelvalentini.u5d3ex.model;

import java.time.LocalTime;
import java.util.List;


public class Order {
    protected static int counter = 0;
    List<MenuItem> menuItemList;
    int orderSeats;
    double totalAmount;
    LocalTime orderTime;
    int orderNumber;
    OrderStatus orderStatus;
    Table table;

    public Order(List<MenuItem> menuItemList, double coverCharge, int orderSeats, OrderStatus orderStatus, Table table) {
        this.menuItemList = menuItemList;
        this.orderSeats = orderSeats;
        double totalAmount = 0;
        for (MenuItem item : menuItemList) {
            totalAmount += item.getPrice();
        }
        totalAmount += orderSeats * coverCharge;
        this.totalAmount = totalAmount;
        this.orderTime = LocalTime.now();
        this.orderNumber = ++counter;
        this.orderStatus = orderStatus;
        table.setOccupied(true);
        this.table = table;
    }


    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public int getOrderSeats() {
        return orderSeats;
    }

    public void setOrderSeats(int orderSeats) {
        this.orderSeats = orderSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }


    public LocalTime getOrderTime() {
        return orderTime;
    }


    public int getOrderNumber() {
        return orderNumber;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Order{" +
                "menuItemList=" + menuItemList +
                ", orderSeats=" + orderSeats +
                ", totalAmount=" + totalAmount +
                ", orderTime=" + orderTime +
                ", orderNumber=" + orderNumber +
                ", orderStatus=" + orderStatus +
                ", table=" + table +
                '}';
    }
}
