package vetclinic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TheGuestsOnTheWaitingList  implements Question<List<Pet>> {

    private final PetHotel petHotel;

    public TheGuestsOnTheWaitingList(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getInWaitPets();
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new TheGuestsOnTheWaitingList(petHotel);
    }
}