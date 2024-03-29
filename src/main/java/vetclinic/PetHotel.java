package vetclinic;

import java.util.ArrayList;
import java.util.List;

public class PetHotel {

    List<Pet> pets = new ArrayList<>();

    public void checkInPet(Pet pet)
    {
        pets.add(pet);
    }


    public void checkOutPet(Pet pet)
    {
        pets.removeIf(p -> p.equals(pet));
    }

    public List<Pet> getPets()
    {
        return this.pets;
    }
}
