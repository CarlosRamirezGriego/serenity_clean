package vetclinic;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

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

        //When
        //petra.attemptsTo(
        //        new CheckIn(ginger, petHotel)
        //);

        //Then

        //Assert
    }

}
