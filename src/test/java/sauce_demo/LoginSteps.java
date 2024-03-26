package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import sauce_demo.actions.login.LoginActions;

public class LoginSteps {

    @Steps
    LoginActions login;

    @Given("^Colin is on the login page$")
    public void colin_is_on_the_login_page() {
        login.openTheLoginPage();
    }


    @When("Colin/he attempts to login with the following credentials:")
    public void attemptsToLoginWithTheFollowingCredentials(UserCredentials userCredentials) {
        login.withCredentials(userCredentials.username(), userCredentials.password());
    }

    @Then("Colin/he should be presented with the error message {}")
    public void heShouldBePresentedWithTheErrorMessageMessage(String errorMessage) {
        assertThat(login.errorMessage(),  containsString(errorMessage));
    }

}
