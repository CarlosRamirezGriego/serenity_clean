package serenity_clean;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderCoffeeSteps {
    Order order = new Order();
    Customer cathy = new Customer();
    Barista barry = new Barista("Barry");

    @Given("^Cathy is (\\d+) (?:meter|meters) from the coffee shop$")
    public void cathy_is_meters_from_the_coffee_shop(int distanceInMeters) {
        cathy = new Customer("Cathy", distanceInMeters);

    }
    @When("^Cathy (?:orders|has ordered) a (Small|Regular|Large) (.*)$")
    public void cathy_orders_a(String size, String orderName) {
        cathy.makeOrder(size, orderName, 1);
    }
    @Then("^Barry should receive an order$")
    public void barry_should_receive_an_order() {
        barry.getLatestOrderInQueue();
    }

    @Then("^Barry should know that the coffee priority is (Low|Normal|Urgent)$")
    public void barry_should_know_that_the_coffee_priority_is(String expectedPriority) {
        UrgencyLevel urgency = UrgencyLevel.valueOf(expectedPriority.toUpperCase());
        assertThat(barry.checkCurrentOrderInformation().returnOrderUrgencyLevel(),  equalTo(urgency));
    }


}
