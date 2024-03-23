package serenity_clean;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderCoffeeSteps {
    @Given("Cathy is {int} meters from the coffee shop")
    public void cathy_is_meters_from_the_coffee_shop(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("a");
    }
    @When("Cathy orders a large cappuccino")
    public void cathy_orders_a_large_cappuccino() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("a");
    }
    @Then("Barry should receive an order")
    public void barry_should_receive_an_order() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("a");
    }
    @Then("Barry should know that the coffee is Urgent")
    public void barry_should_know_that_the_coffee_is_urgent() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("a");
    }

}
