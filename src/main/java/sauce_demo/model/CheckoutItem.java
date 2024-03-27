package sauce_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckoutItem {
    private final int quantity;
    private final String description;
    private final String price;

    public CheckoutItem(@JsonProperty("quantity") int quantity, @JsonProperty("description") String description, @JsonProperty("price") String price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
