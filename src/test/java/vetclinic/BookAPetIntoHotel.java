package vetclinic;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityRunner.class)
public class BookAPetIntoHotel {

    @Test
    public void petra_books_her_pet_cat_into_the_hotel()
    {
        // Given
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.Cat().named("Ginger");
        PetHotel petHotel = new PetHotel();

        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        //assertThat(petHotel.getPets(), hasItem(ginger));
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), hasItem(ginger)));
    }


    @Test
    public void petra_checks_her_cat_out_of_the_hotel()
    {
        // Given
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.Cat().named("Ginger");
        PetHotel petHotel = new PetHotel();
        CheckIn.aPet(ginger).into(petHotel);

        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );

        //assertThat(petHotel.getPets(), not(hasItem(ginger)));
        petra.should(seeThat(TheRegisteredGuests.in(petHotel), not(hasItem(ginger))));
    }

    @Test
    public void petra_books_her_pet_cat_into_the_hotel_that_is_already_full() {
        Actor petra = Actor.named("Petra the pet owner");
        Actor harry = Actor.named("Harry the hotel manager");
        Pet ginger = Pet.Cat().named("Ginger");
        PetHotel petHotel = APetHotel.called("Pet Hotel California").withResidents(20);
        CheckIn.aPet(ginger).into(petHotel);

        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );

        harry.should(seeThat(TheGuestsOnTheWaitingList.in(petHotel), hasItem(ginger)));
    }

}
