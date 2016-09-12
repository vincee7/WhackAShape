package game;
import student.TestCase;


/**
 * Test case for the simple array bag
 * @author vincee7
 * @version 2016.07.19
 *
 */
public class SimpleArrayBagTest extends TestCase
{

    private SimpleArrayBag bag;
    
    
    /**
     * sets up each test case with a simplearraybag with three items
     * 
     */
    public void setUp() 
    {
        bag = new SimpleArrayBag();
        bag.add("test");
        bag.add("test");
        bag.add("test1");
        
    }

    /**
     * tests the add method
     * checks for null entry and if the bag is full
     */
    public void testAdd()
    {
        String badboy = null;
        assertFalse(bag.add(badboy));
        for (int i = 0; i < 22; i++)
        {
            bag.add("test");
        }
        
        assertFalse(bag.add(badboy));
        
    }
    
    /**
     * tests to make sure getcurrentsize returns the right size
     */
    public void testGetCurrentSize()
    {
     
        assertEquals(bag.getCurrentSize(), 3);
        
    }
    
    /**
     * tests the method to check if the bag is empty
     * created a new bag for this
     */
    public void testIsEmpty()
    {
        SimpleArrayBag bag2 = new SimpleArrayBag();
        assertTrue(bag2.isEmpty());
        
    }
    
    /**
     * tests to see if it picks a random object from the bag
     */
    public void testPick()
    {
        SimpleArrayBag bag2 = new SimpleArrayBag();
        assertNull(bag2.pick());
        
        Object string = bag.pick();
        assertTrue(string.equals("test") || string.equals("test1"));
    }
    
    /**
     * tests if the remove method works
     */
    public void testRemove()
    {
        assertTrue(bag.remove("test1"));
        assertFalse(bag.remove("test2"));
    }
    
    
    

}

