package sauce_demo;

import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import sauce_demo.actions.catalog.InventoryActions;
import sauce_demo.actions.navigation.NavigateActions;

public class CatalogSteps {
    @Steps
    NavigateActions navigate;

    @Steps
    InventoryActions inventoryActions;

    @When("Colin/he is browsing the product catalog")
    public void browsingTheCatalog() {
        navigate.toInventoryPage();
    }

    @When("Colin/he has opened the product details for {string}")
    public void opensProductDetails(String productName) {
        inventoryActions.viewDetailsFor(productName);
    }
}
