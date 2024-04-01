package trains;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie the Traveler");


    @Test
    public void the_TFL_page_title_should_be_visible()
    {
        carrie.can(BrowseTheWeb.with(browser));
        carrie.attemptsTo(Open.url("https://tfl.gov.uk/"));
        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }


    @Test
    public void the_TFL_status_updates_page_title_should_be_visible()
    {
        carrie.can(BrowseTheWeb.with(browser));
        carrie.attemptsTo(Open.url("https://tfl.gov.uk/tube-dlr-overground/status/"));
        carrie.should(seeThat(TheWebPage.title(), containsString("status updates")));
    }

}
