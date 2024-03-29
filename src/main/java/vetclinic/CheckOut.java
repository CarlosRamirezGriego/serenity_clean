package vetclinic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class CheckOut implements Performable {

    private final Pet pet;
    private final PetHotel petHotel;

    public CheckOut(Pet pet, PetHotel petHotel)
    {
        this.pet = pet;
        this.petHotel = petHotel;
    }


    public static CheckOutBuilder aPet(Pet pet)
    {
        return new CheckOutBuilder(pet);
    }


    @Override
    public <T extends Actor> void performAs(T actor)
    {
        this.petHotel.checkOutPet(this.pet);
    }


    public static class CheckOutBuilder{

        Pet pet;

        public CheckOutBuilder(Pet pet)
        {
            this.pet = pet;
        }

        public Performable from(PetHotel petHotel)
        {
            return new CheckOut(this.pet, petHotel);
        }
    }
}
