package sauce_demo.model;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.annotations.Step;

public class LoginActions extends UIInteractionSteps {
    @Step
    public void openTheLoginPage() {
        openUrl("https://www.saucedemo.com/");
    }

    @Step("Login with valid credentials")
    public void withValidCredentials() {
        withCredentials("standard_user","secret_sauce");
    }

    public void withCredentials(String username, String password) {
        $(LoginForm.USERNAME).sendKeys(username);
        $(LoginForm.PASSWORD).sendKeys(password);
        $(LoginForm.LOGIN).click();
    }

    public String errorMessage() {
        return $(LoginForm.ERROR_MESSAGE).getText();
    }
}