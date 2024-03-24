package serenity_clean;

import java.util.ArrayList;
import java.util.List;

public class Barista {

    private String name;
    private Order currentOrder;

    public Barista(String name)
    {
        this.name = name;
    }

    public void getLatestOrderInQueue()
    {
        currentOrder = CoffeeShop.findNextOrderInLine();
        CoffeeShop.removeOrderFromQueue();
    }

    public Order checkCurrentOrderInformation()
    {
        return this.currentOrder;
    }
}
