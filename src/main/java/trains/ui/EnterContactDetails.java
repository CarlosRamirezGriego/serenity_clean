package trains.ui;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterContactDetails implements Performable {

    private final String title;
    private final String firstName;
    private final String lastName;


    public EnterContactDetails(String title, String firstName, String lastName)
    {
        this.firstName = firstName;
        this.title = title;
        this.lastName = lastName;
    }

    public static Performable forCustomer(String title, String firstName, String lastName)
    {
        return instrumented(EnterContactDetails.class, title, firstName, lastName);
    }


    @Override
    @Step("{0} enters contact details for #title  #firstName  #lastName")
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(title).from(ContactForm.TITLE.formOption()),
                Enter.theValue(firstName).into(ContactForm.FIRST_NAME.formOption()),
                Enter.theValue(lastName).into(ContactForm.LAST_NAME.formOption())
        );
    }

}
