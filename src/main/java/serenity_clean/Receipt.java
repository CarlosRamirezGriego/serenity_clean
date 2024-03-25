package serenity_clean;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    List<Item> items = new ArrayList<>();
    private double serviceFee;


    public Receipt()
    {

    }


    public Receipt(List<Item> items, double fee){
        this.items = items;
        this.serviceFee = fee;
    }


    public double getSubtotal()
    {
        final double[] total = {0.0};
        items.forEach(item -> {
            total[0] += item.getCost();
        });
        return total[0];
    }


    public double getFee()
    {
        return this.serviceFee;
    }


    public double getTotal()
    {
        return this.serviceFee + this.getSubtotal();
    }

}
