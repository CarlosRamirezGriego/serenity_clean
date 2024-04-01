package vetclinic;

import java.util.ArrayList;
import java.util.List;

public class PetHotel {

    private List<Pet> pets = new ArrayList<>();
    private List<Pet> waitLinePets = new ArrayList<>();
    private String name;
    private int currentResidents;
    private int maxResidents = 20;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setResidents(int residents)
    {
        this.currentResidents = residents;
    }
    public void setMaxResidents(int residents)
    {
        this.maxResidents = residents;
    }

    public void checkInPet(Pet pet)
    {
        if(currentResidents == maxResidents)
        {
            waitLinePets.add(pet);
        }
        else
        {
            pets.add(pet);
        }
    }

    public void checkOutPet(Pet pet)
    {
        pets.removeIf(p -> p.equals(pet));
    }

    public List<Pet> getPets()
    {
        return this.pets;
    }

    public List<Pet> getInWaitPets()
    {
        return this.waitLinePets;
    }

}
