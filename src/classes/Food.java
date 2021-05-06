package classes;

public class Food
{
    private String foodDetails;
    private boolean isDelivered;
    private Food nextDay;

    public Food(String foodDetails)
    {
        this.foodDetails = foodDetails;
        this.isDelivered = false;
    }

    public boolean isDelivered()
    {
        return isDelivered;
    }

    public void setDelivered(boolean delivered)
    {
        this.isDelivered = delivered;
    }

    public String getFoodDetails()
    {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails)
    {
        this.foodDetails = foodDetails;
    }

    public Food getNextDay()
    {
        return nextDay;
    }

    public void setNextDay(Food nextDay)
    {
        this.nextDay = nextDay;
    }
}
