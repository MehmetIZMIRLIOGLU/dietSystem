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
        dieticians.add(new Dietician("Ozan","Güven",2000,Genders.Male));
        dieticians.add(new Dietician("Can","Yılmaz",2000,Genders.Male));
        dieticians.add(new Dietician("Zafer","Algöz",2000,Genders.Male));
        dieticians.add(new Dietician("Şevket","Çoruh",2000,Genders.Male));
        Dietician dietician2 = new Dietician("Çağlar","Çorumlu",2000,Genders.Male);
        dieticians.add(dietician2);
        Dietician dietician = new Dietician("Tüvana", "Yeni", 2000, Genders.Female);
        dieticians.add(dietician);
        dietician.addRank(5);
        dietician2.addRank(4);
        Customer customer = new Customer("Volkan","Gürgör",2000,90.5,173,Genders.Male,Packages.Weekly,"ABC Mah. XYZ Sitesi No:123/Z Süleymanpaşa/Tekirdağ");
        Customer customer2 = new Customer("Behlül","Haznedar",1980,70,173,Genders.Male,Packages.Weekly,"Haznedar Konakları");
        customer.setDietician(dietician);
        dietician.addCustomer(customer);
        customers.add(customer);
        customers.add(customer2);

        FoodList foodList = new FoodList();
        for (int i=0; i<7; i++)
            foodList.addFood("For Day " + (i+1) + "\n\n\n" + "Breakfast\n" +
                    "Start the week with one of the best time-saving keto breakfasts of all time – keto egg muffins. If you want something more daring, feel free to switch to another breakfast option.\n" +
                    "\n" +
                    "You can also have coffee or tea. Small amounts of full-fat milk or cream are okay.\n" +
                    "\n\nLunch\n" +
                    "A simple yet tasty no-cook keto plate that should keep you satiated until dinner – keto turkey plate.\n" +
                    "\n" +
                    "Lunch out is not recommended, but if necessary, follow these guidelines.\n\n\n" + "Dinner\n" +
                    "This amazing cheeseburger salad is quick, inexpensive, and filled with all of the best flavors of a juicy cheeseburger. The ingredients come together for a familiar and favorite taste sensation that makes you wonder why you ever ate burgers on a bun!\n" +
                    "\n" +
                    "Cook enough so you have leftovers for lunch tomorrow (that means plan on 2 servings per person).");
        customer.setFoodList(foodList);
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
