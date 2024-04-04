package todomvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Test;
import org.junit.runner.RunWith;
import vetclinic.Pet;

@RunWith(SerenityRunner.class)
public class WhenUsingSimpleEnsureStatements {
    @Test
    public void we_should_be_able_to_make_assertions_about_strings(){
        Actor penny = Actor.named("Penny");
        Pet fido = new Pet("Dog");
        fido.setName("Fido");

        penny.attemptsTo(
                Ensure.that(fido.getName()).isEqualTo("Fido")
        );
    }
}
