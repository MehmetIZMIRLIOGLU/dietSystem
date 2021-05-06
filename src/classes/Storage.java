package classes;

import java.util.ArrayList;

public class Storage
{
    private static ArrayList<Dietician> dieticians;
    private static ArrayList<Customer> customers;
    public static Dietician currentDietician;
    public static Customer currentCustomer;

    public static void startProgram()
    {
        dieticians = new ArrayList<Dietician>();
        customers = new ArrayList<Customer>();
        dieticians.add(new Dietician("Mehmet","İzmirlioğlu",2000,Genders.Male));
        Dietician dietician = new Dietician("Tüvana", "Yeni", 2000, Genders.Female);
        dieticians.add(dietician);
        Customer customer = new Customer("Volkan","Gürgör",2000,90.5,173,Genders.Male,Packages.Weekly,"ABC Mah. XYZ Sitesi No:123/Z Süleymanpaşa/Tekirdağ");
        customer.setDietician(dietician);
        customers.add(customer);
        dietician.addCustomer(customer);
    }
    
    public static ArrayList<Dietician> getDieticians()
    {
        return dieticians;
    }

    public static void addDietician(Dietician dietician)
    {
        dieticians.add(dietician);
    }

    public static ArrayList<Customer> getCustomers()
    {
        return customers;
    }

    public static void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
}
