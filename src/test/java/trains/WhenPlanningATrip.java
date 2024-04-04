package trains;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import trains.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie the Traveler");

    @Before
    public void setTheStage()
    {
        carrie.can(BrowseTheWeb.with(browser));

        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES)
        );
    }


    @Test
    public void the_TFL_page_title_should_be_visible()
    {
        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class));
        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }


    @Test
    public void the_TFL_status_updates_page_title_should_be_visible()
    {
        carrie.attemptsTo(Open.url("https://tfl.gov.uk/tube-dlr-overground/status/"));
        carrie.should(seeThat(TheWebPage.title(), containsString("status updates")));
    }


    @Test
    public void should_be_able_to_search_for_station_details()
    {
        carrie.attemptsTo(
                Search.forStation("Waterloo")
        );
        carrie.should(seeThat(
                SearchResults.heading(), equalTo("Search: Waterloo"), equalTo("Search: Waterloo")
        ));
    }

    @Test
    public void should_list_all_relevant_station_information()
    {
        carrie.attemptsTo(
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );
        carrie.should(seeThat(
                TheTarget.textOf(SearchResultsPage.FIRST_ARTICLE_HEADING), containsString("Jubilee")
        ));
    }

    @Test
    public void should_see_status_updates()
    {
        carrie.attemptsTo(
                SelectMenu.option(MenuBar.STATUS_UPDATES)
        );
        carrie.should(seeThat(
                TheServiceLines.displayed() , hasItems("Bakerloo", "Circle", "Central")
        ));
    }


    @Test
    public void should_be_able_to_contact_tfl()
    {
        carrie.attemptsTo(
                SelectMenu.option(MenuBar.HELP_AND_CONTACT),
                Click.on(HelpAndContacts.AboutOyster.TFLApp)
        );

        carrie.attemptsTo(
                EnterContactDetails.forCustomer("Mrs","Sara-Jane", "Smith")
        );

        carrie.should(
                seeThat(TheContactDetails.title(), equalTo("Mrs")),
                seeThat(TheContactDetails.firstName(), equalTo("Sara-Jane")),
                seeThat(TheContactDetails.lastName(), equalTo("Smith"))
        );
    }


}
