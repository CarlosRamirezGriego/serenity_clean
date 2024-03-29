package vetclinic;

import java.util.ArrayList;
import java.util.List;

public class PetHotel {

    List<Pet> pets = new ArrayList<>();

    public void checkInPet(Pet pet)
    {
        pets.add(pet);
    }
}
