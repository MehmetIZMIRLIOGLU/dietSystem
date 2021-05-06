package classes;

public class Customer
{
    private String name;
    private String surname;
    private int birth_year;
    private double weight;
    private double height;
    private Genders gender;
    private Packages pack;
    private Dietician dietician;
    private String address;

    public Customer(String name, String surname, int birth_year, double weight, double height, Genders gender, Packages pack, String address)
    {
        this.name = name;
        this.surname = surname;
        this.birth_year = birth_year;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.pack = pack;
        this.address = address;
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

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public Genders getGender()
    {
        return gender;
    }

    public void setGender(Genders gender)
    {
        this.gender = gender;
    }

    public Packages getPack()
    {
        return pack;
    }

    public void setPack(Packages pack)
    {
        this.pack = pack;
    }

    public Dietician getDietician()
    {
        return dietician;
    }

    public void setDietician(Dietician dietician)
    {
        this.dietician = dietician;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return name + " " + surname;
    }
}
