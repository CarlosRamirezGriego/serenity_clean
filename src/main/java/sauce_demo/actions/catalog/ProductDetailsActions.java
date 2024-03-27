package sauce_demo.actions.catalog;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;


public class ProductDetailsActions extends UIInteractionSteps {

    @Step("Add the current item to the cart")
    public void addToCart() {
        find(Button.withText("Add to cart")).click();
    }
}