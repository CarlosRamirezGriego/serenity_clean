package serenity_clean;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

    public static List<Order> orders = new ArrayList<>();

    public static Order findNextOrderInLine()
    {
        if(orders.size() > 0)
        {
            return orders.get(0);
        }
        return null;
    }


    public static void removeOrderFromQueue()
    {
        if(orders.size() > 0)
        {
            orders.remove(0);
        }
    }


    public static void addOrderToQueue(Order order)
    {
        orders.add(order);
    }



}