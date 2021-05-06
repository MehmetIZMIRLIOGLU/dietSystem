package classes;

public class FoodList
{
    private Food first;

    public void addFood(String foodDetails)
    {
        Food food = new Food(foodDetails);
        if(first == null)
            first = food;
        else
        {
            Food node = first;
            while(node.getNextDay() != null)
                node = node.getNextDay();
            node.setNextDay(food);
        }
    }

    public int getSize()
    {
        int i = 1;
        Food node = first;
        while(node != null)
        {
            node = node.getNextDay();
            i++;
        }
        return i;
    }

    public String getFoodDetails(int day)
    {
        int i = 1;
        Food node = first;
        while(node != null)
        {
            if(i == day)
                return node.getFoodDetails();
            node = node.getNextDay();
            i++;
        }
        return "";
    }

    public boolean setOrdered(int day)
    {
        int i = 1;
        Food node = first;
        while(node != null)
        {
            if(i == day)
            {
                node.setDelivered(true);
                return true;
            }
            node = node.getNextDay();
            i++;
        }
        return false;
    }

    public boolean setOrdered(Food food)
    {
        if(food == null)
            return false;
        food.setDelivered(true);
        return true;
    }
}
