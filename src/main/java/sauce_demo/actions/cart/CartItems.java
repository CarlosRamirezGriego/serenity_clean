package sauce_demo.actions.cart;
import net.serenitybdd.core.steps.UIQuerySteps;
import sauce_demo.model.CheckoutItem;
import sauce_demo.model.TotalItemPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartItems extends UIQuerySteps {
    public List<String> itemNames() {
        return findAll(".inventory_item_name").texts();
    }

    public List<CheckoutItem> items() {
        return findAll(".cart_item")
                .stream()
                .map(row -> new CheckoutItem(
                                Integer.parseInt(row.findBy(".cart_quantity").getText()),
                                row.findBy(".inventory_item_name").getText(),
                                row.findBy(".inventory_item_price").getText()
                        )
                ).collect(Collectors.toList());
    }

    public TotalItemPrice totalItemPrice() {
        return new TotalItemPrice(
                $(".summary_subtotal_label").getText().split(": ")[1],
                $(".summary_tax_label").getText().split(": ")[1],
                $(".summary_total_label").getText().split(": ")[1]
        );
    }

    public List<List<String>> returnItemsAsList()
    {
        List<List<String>> allData = new ArrayList<>();
        List<CheckoutItem> items = this.items();
        for(CheckoutItem c : items)
        {
            List<String> data = new ArrayList<>();
            data.add(Integer.toString(c.getQuantity()));
            data.add(c.getDescription());
            data.add(c.getPrice());
            allData.add(data);
        }
        return allData;
    }


    public static List<List<String>> returnItemsAsList(List<CheckoutItem> checkoutItems)
    {
        List<List<String>> allData = new ArrayList<>();
        for(CheckoutItem c : checkoutItems)
        {
            List<String> data = new ArrayList<>();
            data.add(Integer.toString(c.getQuantity()));
            data.add(c.getDescription());
            data.add(c.getPrice());
            allData.add(data);
        }
        return allData;
    }
}