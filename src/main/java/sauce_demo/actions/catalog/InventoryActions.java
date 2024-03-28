package sauce_demo.actions.catalog;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Link;
import net.serenitybdd.screenplay.ui.PageElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class InventoryActions extends UIInteractionSteps {

    public static List<String> itemsAdd = new ArrayList<>();

    @Step("Add '{0}' to the cart")
    public void addToCart(String item) {
        find(Button.withText("Add to cart").inside(inventoryItemWithName(item))).click();
    }

    private SearchableTarget inventoryItemWithName(String item) {
        return PageElement.locatedBy(".inventory_item").containingText(item);
    }

    @Step("View product details for '{0}'")
    public void viewDetailsFor(String item) {
        find(Link.withText(item)).click();
    }

    @Step("Remove '{0}' from the cart")
    public void removeFromCart(String item) {
        find(Button.withText("Remove").inside(inventoryItemWithName(item))).click();
    }
}