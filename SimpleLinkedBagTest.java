package game;
import student.TestCase;


/**
 * Test case for the linked bag
 * @author vincee7
 * @version 2016.07.19
 *
 */
public class SimpleLinkedBagTest extends TestCase
{

    private SimpleLinkedBag bag;
    
    
    /**
     * sets up the test case for each test
     */
    public void setUp()
    {
        bag = new SimpleLinkedBag();
        bag.add("test");
        bag.add("test");
        bag.add("test1");
        
    }

    /**
     * tests that an item wont be added if its null
     */
    public void testAdd()
    {
        String badboy = null;
        assertFalse(bag.add(badboy));
        
        
    }
    
    /**
     * tests to make sure getcurrentsize returns the actual size
     */
    public void testGetCurrentSize()
    {
     
        assertEquals(bag.getCurrentSize(), 3);
        
    }
    
    /**
     * tests to make sure the method returns true if the bag is empty
     */
    public void testIsEmpty()
    {
        SimpleLinkedBag bag2 = new SimpleLinkedBag();
        assertTrue(bag2.isEmpty());
        
    }
    
    /**
     * tests to make sure a random item is picked from the bag
     */
    public void testPick()
    {
        SimpleLinkedBag bag2 = new SimpleLinkedBag();
        assertNull(bag2.pick());
        
        Object string = bag.pick();
        assertTrue(string.equals("test") || string.equals("test1"));
    }
    
    /**
     * tests to make sure an item is removed from the bag if 
     * its valid and returns false if the item doesnt exist
     * in the bag
     */
    public void testRemove()
    {
        
        assertTrue(bag.remove("test1"));
        assertFalse(bag.remove("test2"));
    }

    

}
