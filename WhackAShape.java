package game;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import CS2114.SquareShape;
import student.TestableRandom;
import CS2114.TextShape;
import java.awt.Color;

import CS2114.Button;
import CS2114.CircleShape;

/**
 * WhackAShape is a game where you click the shapes until they are gone.
 * I used a linked bag for my bag.
 * 
 * @author vincee7
 * @version 2016.07.20
 *
 */
public class WhackAShape 
{
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    private Shape currentShape;
    
    /**
     * default constructor which has one of each shape
     */
    public WhackAShape()
    {
   
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();

        randomGenerator = new TestableRandom();
        
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        
        bag.add(buildShape("red circle"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue square"));
        
        window.addShape(bag.pick());
        
        
    }
    
    /**
     * other constructor with an array of string as input that will add the
     * shapes in the array as long as they are one of the four allowed
     * "red circle, blue circle, red square, blue square"
     * otherwise it will throw an exception
     * 
     * @param string  is the array of strings that are the shapes being
     * added to the game and bag.
     */
    public WhackAShape(String[] string)
    {
        bag = new SimpleLinkedBag<Shape>();
        window = new Window();
        
        randomGenerator = new TestableRandom();
        
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        
        for (int i = 0; i < string.length; i++)
        {
            Exception thrown = null;
            try 
            {
                bag.add(buildShape(string[i]));
            }
            catch (Exception exception)
            {
                thrown = exception;
                thrown.printStackTrace();
            }
        }
        
        window.addShape(bag.pick());
        
    }
    
    /**
     * returns the bag of shapes
     * @return  the bag to be returned
     */
    public SimpleBagInterface<Shape> getBag()
    {
        return bag;
    }
    
    /**
     * returns the window for the game
     * @return  the window to be returned
     */
    public Window getWindow()
    {
        return window;
    }
    
    /**
     * causes the system to quit and close the window once you click 
     * the quit button
     * @param button  the quit button
     */
    public void clickedQuit(Button button)
    {
        
        System.exit(0);
        
    }
    
    /**
     * causes the shape to be removed and the next shape to appear when
     * the shape is clicked. will pick a random shape out of the bag
     * if the bag is empty it will display you win on the window
     * @param shape  the shape that is clicked
     */
    public void clickedShape(Shape shape)
    {
        window.removeShape(shape);
        bag.remove(shape);
        
        Shape nextShape = bag.pick();
        if (nextShape == null)
        {
            
            
            TextShape text =  new TextShape(0, 0, "You Win!");
            int x = window.getGraphPanelWidth() / 2 - text.getWidth() / 2;
            int y = window.getGraphPanelHeight() / 2 - text.getHeight() / 2;
            text.setX(x);
            text.setY(y);
            
            window.addShape(text);
        }
        else
        {
            window.addShape(nextShape);
        }
    }
    
    /**
     * builds the shape to be added as one of the four allowed.
     * either red or blue squares or circles
     * @param string the string that says which shape it is
     * @return  the shape that is returned
     */
    private Shape buildShape(String string)
    {
        int size = randomGenerator.nextInt(101)+ 100;
        int x = randomGenerator.nextInt(window.getGraphPanelWidth()
                - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight()
                - size);
        
        
        if (!string.contains("red") && !string.contains("blue"))
        {
            throw new IllegalArgumentException();
        }
        
        if (!string.contains("circle") && !string.contains("square"))
        {
            throw new IllegalArgumentException();
        }
        
        
        
        if (string.contains("circle") && string.contains("red"))
        {
            currentShape = new CircleShape(x, y, size, Color.RED);
        }
        else if (string.contains("circle") && string.contains("blue"))
        {
            currentShape = new CircleShape(x, y, size, Color.BLUE);
        }
        else if (string.contains("square") && string.contains("red"))
        {
            currentShape = new SquareShape(x, y, size, Color.red);
        }
        else if (string.contains("square") && string.contains("blue"))
        {
            currentShape = new SquareShape(x, y, size, Color.BLUE);
        }
        
        currentShape.onClick(this, "clickedShape");
        
        return currentShape;
        
    }

}
