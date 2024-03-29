package vetclinic;

public class Pet {
    private String species;
    private String name;
    private int age;

    Pet(String species)
    {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSpecies() {
        return species;
    }


    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public static PetBuilder Cat()
    {
        return new PetBuilder("Cat");
    }


    public static class PetBuilder
    {
        public Pet pet;

        public PetBuilder(String species)
        {
            this.pet = new Pet(species);
        }

        public Pet named(String name)
        {
            this.pet.setName(name);
            return this.pet;
        }

    }

    @Override
    public String toString()
    {
        return "Im a "+this.species +" named '"+this.name+"'";
    }


}
