package serenity_clean;

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

    @Given("^Cathy is (\\d+) meters from the coffee shop$")
    public void cathy_is_meters_from_the_coffee_shop(int distanceInMeters) {
        cathy = new Customer("Cathy", distanceInMeters);

    }
    @When("^Cathy orders a (.*)$")
    public void cathy_orders_a(String orderName) {
        cathy.makeOrder(orderName, 1);
    }
    @Then("^Barry should receive an order$")
    public void barry_should_receive_an_order() {
        barry.getLatestOrderInQueue();
    }
    @Then("^Barry should know that the coffee is Urgent$")
    public void barry_should_know_that_the_coffee_is_urgent() {
        assertThat(barry.checkCurrentOrderInformation().returnOrderUrgencyLevel(),  equalTo(UrgencyLevel.URGENT));
    }

    @Then("^Barry should know that the coffee is Low Priority$")
    public void barry_should_know_that_the_coffee_is_low_priority() {
        assertThat(barry.checkCurrentOrderInformation().returnOrderUrgencyLevel(),  equalTo(UrgencyLevel.LOWPRIORITY));
    }

    @Then("^Barry should know that the coffee has regular Priority$")
    public void barry_should_know_that_the_coffee_has_regular_priority() {
        assertThat(barry.checkCurrentOrderInformation().returnOrderUrgencyLevel(),  equalTo(UrgencyLevel.NORMAL));
    }


}
