package serenity_clean;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderCoffeeSteps {

    /*
    * This code can be found in this Repository
    * URL: https://github.com/CarlosRamirezGriego/serenity_clean
    * Branch: caffeinateme
    * File: src/test/java_serenity_clean/OrderCoffeeSteps.java
     */


    @Steps(shared = true)

    Customer cathy = new Customer("Cathy");
    Barista barry = new Barista("Barry");
    Map<String, Double> productPrices = new HashMap<>();

    Receipt receipt = new Receipt();

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
        CoffeeShop.updateOrdersByCustomerETA(name, eta);
    }

    @When("^Cathy has ordered$")
    public void cathy_has_ordered(List<Map<String, String>> orders)
    {
        List<Item> items = new ArrayList<>();
        orders.forEach(order -> {
            String product = order.get("Product");
            int quantity = Integer.parseInt(order.get("Quantity"));
            Item item = new Item(product, quantity, productPrices.get(product));
            items.add(item);
        });
        cathy.makeOrder(items);
    }


    @Given("^the Products have the following Prices$")
    public void the_products_have_the_following_prices(List<Map<String, String>> products)
    {
        products.forEach(order -> {
            String product = order.get("Product");
            double price = Double.parseDouble(order.get("Price"));
            productPrices.put(product, price);
        });
    }


    @When("^she asks for a receipt$")
    public void she_asks_for_a_receipt() {
        receipt = CoffeeShop.getCustomerReceipt(cathy.getCustomerName());
        CoffeeShop.removeOrderFromQueue();
    }

    @Then("^she should receive a receipt totalling:$")
    public void she_should_receive_a_receipt_totalling(List<Map<String, String>> receiptTotals) {
        Double serviceFee = Double.parseDouble(receiptTotals.get(0).get("Service fee"));
        Double subtotal = Double.parseDouble(receiptTotals.get(0).get("Subtotal"));
        Double total = Double.parseDouble(receiptTotals.get(0).get("Total"));

        assertThat(receipt.getFee(),  equalTo(serviceFee));
        assertThat(receipt.getSubtotal(),  equalTo(subtotal));
        assertThat(receipt.getTotal(),  equalTo(total));
    }


}
