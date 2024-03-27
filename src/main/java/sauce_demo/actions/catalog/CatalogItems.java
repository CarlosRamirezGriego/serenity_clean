package sauce_demo.actions.catalog;

import net.serenitybdd.core.steps.UIQuerySteps;

import java.util.List;

public class CatalogItems extends UIQuerySteps {
    public List<String> itemNames() {
        return findAll(".inventory_item_name").texts();
    }

    public String shoppingCartBadge() {
        return $(".shopping_cart_badge").getText();
    }
}