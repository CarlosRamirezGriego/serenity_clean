package trains.ui;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import trains.ui.StatusUpdatePage;

import java.util.Collection;
import java.util.List;

public class TheServiceLines {
    public static Question<Collection<String>> displayed()
    {
        return TheTarget.textValuesOf(StatusUpdatePage.SERVICE_LINES);
    }
}
