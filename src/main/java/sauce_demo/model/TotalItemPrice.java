package sauce_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalItemPrice {
    private final String itemTotal;
    private final String tax;
    private final String total;

    public TotalItemPrice(@JsonProperty("itemTotal") String itemTotal, @JsonProperty("tax") String tax, @JsonProperty("total") String total) {
        this.itemTotal = itemTotal;
        this.tax = tax;
        this.total = total;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public String getTax() {
        return tax;
    }

    public String getTotal() {
        return total;
    }
}
