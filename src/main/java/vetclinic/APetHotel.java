package vetclinic;

public class APetHotel {

    public String name;


    public APetHotel(String name)
    {
        this.name = name;
    }

    public static APetHotel called(String name)
    {
        return new APetHotel(name);
    }

    public PetHotel withResidents(int amount)
    {
        PetHotel ph = new PetHotel();
        ph.setName(this.name);
        ph.setResidents(amount);
        ph.setMaxResidents(amount);
        return ph;
    }


}
