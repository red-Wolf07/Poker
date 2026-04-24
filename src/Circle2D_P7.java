import java.awt.Color;
import java.awt.Graphics;

/**
 * Circle2D class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/14/2026)
 */
public class Circle2D_P7 extends Shape2D_P7 {

    private static final int OUTLINE_WIDTH = 10;

    private int diameter;

    /**
     * Default constructor for the Circle2D class
     * Sets the diameter and other variables to default
     * values.
     */
    public Circle2D_P7()
    {
        super();
        diameter = 30;
    }

    /**
     * Overloaded constructor for the Circle2D class
     * Sets the color, x and y positions, and the diameter
     * to specified values.
     * Color is determined by a 'color index', available color
     * indices are in the Shape2D class.
     * Any other variables are set to default values.
     *
     * @param  colorIndex   An integer
     * @param  xPosition    An integer
     * @param  yPosition    An integer
     * @param  diameter     An integer
     */
    public Circle2D_P7(int colorIndex, int xPosition, int yPosition, int diameter)
    {
        super(colorIndex, xPosition, yPosition);
        this.diameter = diameter;
    }

    /**
     * Gets the diameter of the circle
     *
     * @return    The integer value of the variable diameter
     */
    public int getDiameter()
    {
        return diameter;
    }

    /**
     * Sets the diameter of the circle
     *
     * @param  diameter  An integer
     */
    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
    }

    /**
     * Draws the circle onto a canvas.
     * If the circle isn't filled and doesn't
     * have an outline, then the circle is drawn
     * as a black outline without a fill color.
     *
     * @param  canvas  The Graphics plane which the circle
     *                 is drawn on.
     */
    public void draw(Graphics canvas)
    {
        if(isOutlined()) {
            canvas.setColor(getOutlineColor());
            canvas.drawOval(0, 0,
                    diameter + OUTLINE_WIDTH, diameter + OUTLINE_WIDTH);
        }
        else if(!isFilled()){
            canvas.setColor(Color.BLACK);
            canvas.drawOval(0, 0,
                    diameter + OUTLINE_WIDTH, diameter + OUTLINE_WIDTH);
        }

        if(isFilled()){
            canvas.setColor(getFillColor());
        }
        else{
            canvas.setColor(canvas.getColor());
        }
        canvas.fillOval(0, 0,
                diameter, diameter);
    }
}
