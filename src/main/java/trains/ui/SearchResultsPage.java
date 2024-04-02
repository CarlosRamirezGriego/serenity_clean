package trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResultsPage {
    public static final Target SEARCH_RESULTS_HEADING = Target.the("Title").located(By.cssSelector("h1.hero-headline"));
    public static final Target FIRST_ARTICLE_HEADING = Target.the("First Article Heading").located(By.cssSelector(".search-results h2"));
}
