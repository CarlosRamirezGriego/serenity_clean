package sauce_demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import serenity_clean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import sauce_demo.model.LoginActions;

public class LoginSteps {

    @Steps
    LoginActions login;

    @Given("^Colin is on the login page$")
    public void colin_is_on_the_login_page() {
        login.openTheLoginPage();
    }

}
