package game;
import student.TestableRandom;
import bag.SimpleBagInterface;

/**
 * The simple array bag that uses an array to store the items 
 * @author vincee7
 * @version 2016.07.19
 * @param <T> is the type 
 * 
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    /**
     * the capacity of the bag
     */
    public static final int MAX = 25;
    private int numberOfEntries;
    
    /**
     * default constructor that instantiates a bag with max as the 
     * capacity
     */
    public SimpleArrayBag()
    {
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
        
    }
    
    /**
     * adds the inputed item to the bag
     * @param arg is the item to be added
     * @return true if the item was added successfully
     * 
     */
    @Override
    public boolean add(T arg) 
    {
        
        if (numberOfEntries == 25 || arg == null)
        {
            return false;
        }
        bag[numberOfEntries] = arg;
        numberOfEntries++;
        return true;
        
    }

    /**
     * returns the size of the bag
     * @return the number of items in the bag
     */
    @Override
    public int getCurrentSize() 
    {
        
        return numberOfEntries;
    }

    /**
     * returns true if the number of items in the bag is 0
     * @return is true when the bag is empty
     */
    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    /**
     * picks a random item from the bag
     * @return bag is the item to be returned
     */
    @Override
    public T pick() 
    {
        
        if (isEmpty())
        {
            return null;
        }
        
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        
        return bag[index];
        
    }

    /**
     * removes the inputed item from the bag
     * @return returns true if the item was removed
     * returns false if the item doesnt exist in the bag
     * @param arg is the item to be removed
     */
    @Override
    public boolean remove(T arg) 
    {
        int index = getIndexOf(arg);
        
        if (index == -1)
        {
            return false;
        }
        bag[index] = null;
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
        
    }
    
    /**
     * returns the index of the inputed item in the bag
     * @param anEntry  is the inputed item
     * @return  is the index of the item
     */
    private int getIndexOf(T anEntry)
    {
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (bag[i].equals(anEntry))
            {
                return i;
            }
        }
        
        return -1;
        
    }

}
