package trains.ui;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class TheContactDetails {
    public static Question<String> title()
    {
        return TheTarget.selectedValueOf(ContactForm.TITLE.formOption());
    }


    public static Question<String> firstName()
    {
        return TheTarget.valueOf(ContactForm.FIRST_NAME.formOption());
    }


    public static Question<String> lastName()
    {
        return TheTarget.valueOf(ContactForm.LAST_NAME.formOption());
    }
}
