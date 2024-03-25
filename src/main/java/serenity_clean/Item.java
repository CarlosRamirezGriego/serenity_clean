package serenity_clean;
import java.util.regex.*;

public class Item {
    private String name;
    private int amount = 0;
    private String size;
    private double price;


    public Item(String size, String name, int amount)
    {
        this.name = name;
        this.amount = amount;
        this.size = size;
    }


    public Item(String name, int amount, double price)
    {
        String regex = "^(regular|large|small)\\s+(.*)$";
        String keyword;
        String remainder;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        if (matcher.find()) {
            this.size = matcher.group(1);
            this.name = matcher.group(2).trim();
        } else {
            this.name = name;
            this.size = "regular";
        }

        this.amount = amount;
        this.price = price;
    }

    public double getCost()
    {
        return this.amount * this.price;
    }
}
