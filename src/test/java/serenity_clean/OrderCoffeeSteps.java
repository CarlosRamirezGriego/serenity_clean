package serenity_clean;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderCoffeeSteps {

    @Steps(shared = true)

    Customer cathy = new Customer("Cathy");
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

    @Then("^Barry reviews the pending orders$")
    public void barry_reviews_the_pending_order() {
        barry.getLatestOrderInQueue();
    }

    @Then("^Barry should know that the coffee priority is (Low|Normal|Urgent)$")
    public void barry_should_know_that_the_coffee_priority_is(String expectedPriority) {
        UrgencyLevel urgency = UrgencyLevel.valueOf(expectedPriority.toUpperCase());
        assertThat(barry.checkCurrentOrderInformation().returnOrderUrgencyLevel(),  equalTo(urgency));
    }

    @When("^(.*) is (\\d+) (?:minute|minutes) away$")
    public void customer_minutes_away(String name, int eta) {
        CoffeeShop.updateUserETA(name, eta);
    }


}
