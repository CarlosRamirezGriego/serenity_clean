package vetclinic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TheRegisteredGuests implements Question<List<Pet>> {

    private final PetHotel petHotel;

    public TheRegisteredGuests(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor)
    {
        return petHotel.getPets();
    }

    public static Question<List<Pet>> in(PetHotel petHotel)
    {
        return new TheRegisteredGuests(petHotel);
    }

}
