package serenity_clean;

public class Item {
    private String name;
    private int amount = 0;
    private String size;


    public Item(String size, String name, int amount)
    {
        this.name = name;
        this.amount = amount;
        this.size = size;
    }
}
