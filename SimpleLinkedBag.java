package game;
import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * A simple linked bag that uses nodes
 * @author vincee7
 * @version 2016.07.20
 *
 * @param <T> the type
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> 
{

    private Node<T> firstNode;
    private int numberOfEntries;
    
    
    /**
     * the default constructor that sets the first
     * node to null
     */
    public SimpleLinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    
    /**
     * adds an item to the bag
     * @param arg is the item to be added to the bag
     * @return returns true if the item was successfully to the bag 
     */
    @Override
    public boolean add(T arg) 
    {
        Node<T> node = new Node<T>(arg);
        if (arg == null)
        {
            return false;
        }
        if (isEmpty())
        {
            firstNode = node;
            numberOfEntries++;
            
            return true;
        }
        else
        {
            node.setNext(firstNode);
            firstNode = node;
            numberOfEntries++;
            return true;
        }
        
        
        
        
    }

    /**
     * returns the current size of the bag (the number of items)
     * @return returns the number of items
     */
    @Override
    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    /**
     * returns true if the number of items in the bag is 0
     * @return true if bag is empty
     */
    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries == 0;
    }

    /**
     * picks a random item from the bag
     * @return the item in the thats picked
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
        
        Node<T> node = firstNode;
        
        for (int i = 0; i < index; i++)
        {
            node = node.next();
        }
        
        return node.data();
        
    }

    /**
     * removes the inputed item from the bag
     * @param arg is the item to be removed
     * @return returns true if the item was successfully returned
     */
    @Override
    public boolean remove(T arg) 
    {
        
        if (getReferenceTo(arg) == null)
        {
            return false;
        }
        
        Node<T> node = getReferenceTo(arg);
        
        node.setData(firstNode.data());
        firstNode = firstNode.next();
        numberOfEntries--;
        return true;
        
        
    }
    
    /**
     * finds which node references the item inputed
     * @param anEntry the item to be found
     * @return the node the references the item
     */
    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next();
            }
        }
        
        return currentNode;
    }

}
