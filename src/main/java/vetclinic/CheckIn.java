package vetclinic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class CheckIn implements Performable {

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel)
    {
        this.pet = pet;
        this.petHotel = petHotel;
    }


    public static CheckInBuilder aPet(Pet pet)
    {
        return new CheckInBuilder(pet);
    }


    @Override
    public <T extends Actor> void performAs(T actor)
    {
        this.petHotel.checkInPet(this.pet);
    }


    public static class CheckInBuilder{

        Pet pet;

        public CheckInBuilder(Pet pet)
        {
            this.pet = pet;
        }

        public Performable into(PetHotel petHotel)
        {
            return new CheckIn(this.pet, petHotel);
        }
    }
}
