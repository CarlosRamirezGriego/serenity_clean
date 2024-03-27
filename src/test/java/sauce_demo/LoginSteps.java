package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

import sauce_demo.actions.catalog.CatalogItems;
import sauce_demo.actions.login.LoginActions;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    @Steps
    LoginActions login;

    @Steps
    CatalogItems catalogItems;

    @Given("^Colin is on the login page$")
    @When("Colin/he has logged on to the application")
    public void colin_is_on_the_login_page() {
        login.openTheLoginPage();
    }


    @When("Colin/he logs in with valid credentials")
    public void logsInWithValidCredentials() {
        login.withValidCredentials();
    }


    @Then("Colin/he should be presented the product catalog")
    public void shouldBeOnHomePage() {
        assertThat(catalogItems.itemNames(),  is(not(empty())));
    }


    @When("Colin/he attempts to login with the following credentials:")
    public void attemptsToLoginWithTheFollowingCredentials(List<Map<String, String>> credentials) {
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");
        login.withCredentials(username, password);
    }

    @Then("Colin/he should be presented with the error message {}")
    public void heShouldBePresentedWithTheErrorMessageMessage(String errorMessage) {
        assertThat(login.errorMessage(),  containsString(errorMessage));
    }

    @Given("Colin/he has logged onto the application")
    public void aRegisteredUser() {
        login.openTheLoginPage();
        login.withValidCredentials();
    }

}
