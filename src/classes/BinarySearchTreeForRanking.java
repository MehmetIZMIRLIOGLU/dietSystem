package classes;

public class BinarySearchTreeForRanking
{
    class DieticianNode
    {
        Dietician dietician;
        DieticianNode left, right;

        public DieticianNode(Dietician item)
        {
            dietician = item;
            left = right = null;
        }
    }

    DieticianNode root;
    int size;

    public BinarySearchTreeForRanking()
    {
        root = null;
        for (Dietician item:
             Storage.getDieticians())
        {
            insert(item);
        }
    }

    void insert(Dietician dietician)
    {
        root = insertRec(root, dietician);
        size++;
    }

    DieticianNode insertRec(DieticianNode root, Dietician dietician)
    {
        if (root == null)
        {
            root = new DieticianNode(dietician);
            return root;
        }

        if (dietician.getRankAvg() <= root.dietician.getRankAvg())
            root.left = insertRec(root.left, dietician);
        else if (dietician.getRankAvg() > root.dietician.getRankAvg())
            root.right = insertRec(root.right, dietician);

        return root;
    }

    Dietician[] orderedDieticians;
    int orderedDieticiansIndex = -1;

    public Dietician[] order()
    {
        orderedDieticians = new Dietician[size];
        orderedDieticiansIndex = -1;
        orderRec(root);
        return orderedDieticians;
    }

    void orderRec(DieticianNode root)
    {
        if (root != null)
        {
            orderRec(root.right);
            orderedDieticians[++orderedDieticiansIndex] = root.dietician;
            orderRec(root.left);
        }
    }
}
