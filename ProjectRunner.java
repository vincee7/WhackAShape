package game;


/**
 * The project runner class that runs the project depending on what the input is.
 * @author vincee7
 * @version 2016.07.20
 *
 */
public class ProjectRunner 
{
    
    
    /**
     * the main method that runs either the default constructor
     * or the other constructor depending on the input
     * @param string
     */
    public static void main(String[] string)
    {
        if (string.length > 0)
        {
            WhackAShape whack = new WhackAShape(string);
            
        }
        else
        {
            WhackAShape whack = new WhackAShape();
            
        }
    }

}
