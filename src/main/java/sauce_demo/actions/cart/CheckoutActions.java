package sauce_demo.actions.cart;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.By;
import sauce_demo.model.CustomerDetails;

public class CheckoutActions extends UIInteractionSteps {

    @Step("Enter customer details {0}")
    public void enterCustomerDetails(CustomerDetails customerDetails) {
        if (customerDetails.getFirstName() != null) {
            $(InputField.withPlaceholder("First Name")).sendKeys(customerDetails.getFirstName());
        }
        if (customerDetails.getLastName() != null) {
            $(InputField.withPlaceholder("Last Name")).sendKeys(customerDetails.getLastName());
        }
        if (customerDetails.getPostCode() != null) {
            $(InputField.withPlaceholder("Zip/Postal Code")).sendKeys(customerDetails.getPostCode());
        }
        $(Button.withText("Continue")).click();
    }


    public String getError()
    {
        return find(By.cssSelector("div.error-message-container")).getText();
    }

    @Step("Confirm the order")
    public void confirmOrder() {
        $(Button.withText("Finish")).click();
    }
}