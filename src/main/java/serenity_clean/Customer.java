package serenity_clean;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int distanceInMeters = -1;
    private String customerName = null;

    public Customer()
    {

    }

    public Customer(String name, int distance)
    {
        this.distanceInMeters = distance;
        this.customerName = name;
    }


    public int getCustomerDistance()
    {
        return this.distanceInMeters;
    }

    public void makeOrder(List<Item> items)
    {
        Order order = new Order(items, this);
        CoffeeShop.addOrderToQueue(order);
    }


    public void makeOrder(String size, String itemName, int amount)
    {
        List<Item> items = new ArrayList<>();
        Item item = new Item(size, itemName, amount);
        items.add(item);
        this.makeOrder(items);
    }
}
