package classes;

import java.util.ArrayList;

public class Dietician
{
    private String name;
    private String surname;
    private int birth_year;
    private Genders gender;
    private ArrayList<Customer> Customers;
    private int ranked_sum;
    private int ranked_person;
    private double rank_avg;

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

    public double addRank(int rank)
    {
        if(rank < 1 || rank > 5)
            return rank_avg;
        ranked_sum += rank;
        ranked_person++;
        rank_avg = (double)ranked_sum/(double)ranked_person;
        return rank_avg;
    }

    public String getRank_avg()
    {
        return getRankAvg() + " (" + ranked_person + ")";
    }

    public double getRankAvg()
    {
        return rank_avg;
    }

    @Override
    public String toString()
    {
        return name + " " + surname;
    }
}
