package classes;

import java.util.ArrayList;

public class Dietician
{
    private String name;
    private String surname;
    private int birth_year;
    private Genders gender;
    private ArrayList<Customer> Customers;

    public Dietician(String name, String surname, int birth_year, Genders gender)
    {
        this.name = name;
        this.surname = surname;
        this.birth_year = birth_year;
        this.gender = gender;
        this.Customers = new ArrayList<Customer>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getBirth_year()
    {
        return birth_year;
    }

    public void setBirth_year(int birth_year)
    {
        this.birth_year = birth_year;
    }

    public Genders getGender()
    {
        return gender;
    }

    public void setGender(Genders gender)
    {
        this.gender = gender;
    }

    public ArrayList<Customer> getCustomers()
    {
        return Customers;
    }

    public void addCustomer(Customer customer)
    {
        Customers.add(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        Customers.remove(customer);
    }

    @Override
    public String toString()
    {
        return name + " " + surname;
    }
}
