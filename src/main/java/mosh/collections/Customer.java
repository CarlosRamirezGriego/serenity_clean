package mosh.collections;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;

    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
    }


    public String getEmail()
    {
        return this.email;
    }

    @Override
    public int compareTo(Customer other){
        return name.compareTo(other.name);
    }


    @Override
    public String toString()
    {
        return this.name;
    }
}
