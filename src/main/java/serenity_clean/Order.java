package serenity_clean;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private UrgencyLevel urgency;
    private List<Item> items = new ArrayList<>();

    private Customer customer;
    private int orderedDistance = -1;

    public Order()
    {
    }

    public Order(List<Item> i, Customer c)
    {
        this.items = i;
        this.customer = c;
        if(c.getCustomerDistance() >= 500)
        {
            System.out.println("Urgency set to LOW");
            this.urgency = UrgencyLevel.LOWPRIORITY;
        }
        else if(c.getCustomerDistance() >= 200)
        {
            System.out.println("Urgency set to NORMAL");
            this.urgency = UrgencyLevel.NORMAL;
        }
        else if(c.getCustomerDistance() <= 100)
        {
            System.out.println("Urgency set to URGENT");
            this.urgency = UrgencyLevel.URGENT;
        }
        this.orderedDistance = c.getCustomerDistance();
    }

    public UrgencyLevel returnOrderUrgencyLevel()
    {
        return this.urgency;
    }

}
