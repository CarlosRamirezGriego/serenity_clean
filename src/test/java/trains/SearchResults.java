package trains;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import org.openqa.selenium.Keys;
import trains.ui.SearchResultsPage;
import trains.ui.TFLHomePage;

public class SearchResults {

    public static Question<String> heading()
    {
        return TheTarget.textOf(SearchResultsPage.SEARCH_RESULTS_HEADING);
    }
}
