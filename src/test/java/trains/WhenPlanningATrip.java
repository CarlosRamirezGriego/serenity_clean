package trains;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
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
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
                Enter.theValue("Waterloo").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );
        carrie.should(seeThat(
                TheTarget.textOf(SearchResultsPage.SEARCH_RESULTS_HEADING), equalTo("Search: Waterloo")
        ));
    }

    @Test
    public void should_list_all_relevant_station_information()
    {
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
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
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
                Click.on(MenuBar.STATUS_UPDATES.menuOption())
        );
        carrie.should(seeThat(
                TheTarget.textValuesOf(StatusUpdatePage.SERVICE_LINES), hasItems("Bakerloo", "Circle", "Central")
        ));
    }


    @Test
    public void should_be_able_to_contact_tfl()
    {
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES),
                Click.on(MenuBar.HELP_AND_CONTACT.menuOption()),
                Click.on(HelpAndContacts.AboutOyster.TFLApp)
        );

        carrie.attemptsTo(
                SelectFromOptions.byVisibleText("Mrs").from(ContactForm.TITLE.formOption()),
                Enter.theValue("Sara-Jane").into(ContactForm.FIRST_NAME.formOption()),
                Enter.theValue("Smith").into(ContactForm.LAST_NAME.formOption())

        );

        carrie.should(
                seeThat(TheTarget.selectedValueOf(ContactForm.TITLE.formOption()), equalTo("Mrs")),
                seeThat(TheTarget.valueOf(ContactForm.FIRST_NAME.formOption()), equalTo("Sara-Jane")),
                seeThat(TheTarget.valueOf(ContactForm.LAST_NAME.formOption()), equalTo("Smith"))
        );
    }


}
