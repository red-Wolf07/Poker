import java.awt.*;

/**
 * Oval class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/16/2026)
 */
public class Oval2D extends Shape2D{

    private static final int OUTLINE_WIDTH = 10;
    private int horizontalDiameter;
    private int verticalDiameter;

    /**
     * Default constructor for the Oval2D class
     * The horizontal and vertical diameters, as well as
     * any other variables, are set to default values.
     */
    public Oval2D()
    {
        super();
        horizontalDiameter = 10;
        verticalDiameter = 20;
    }

    /**
     * Overloaded constructor for the Oval2D class
     * Sets the color, x and y positions, horizontal diameter,
     * and vertical diameter to specified values.
     * Color is determined by a 'color index', available color
     * indices are in the Shape2D class.
     * All other variables are set to default values.
     *
     * @param  colorIndex   An integer
     * @param  xPosition    An integer
     * @param  yPosition    An integer
     * @param  hDiameter    An integer
     * @param  vDiameter    An integer
     */
    public Oval2D(int colorIndex, int xPosition, int yPosition, int hDiameter, int vDiameter)
    {
        super(colorIndex, xPosition, yPosition);
        horizontalDiameter = hDiameter;
        verticalDiameter = vDiameter;
    }

    /**
     * Gets the horizontal diameter of the Oval
     *
     * @return    The integer value of the horizontalDiameter
     */
    public int getHorizontalDiameter()
    {
        return horizontalDiameter;
    }

    /**
     * Gets the vertical diameter of the Oval
     *
     * @return    The integer value of the verticalDiameter
     */
    public int getVerticalDiameter()
    {
        return verticalDiameter;
    }

    /**
     * Sets the Oval's horizontal diameter
     *
     * @param  newDiameter  An integer
     */
    public void setHorizontalDiameter(int newDiameter)
    {
        horizontalDiameter = newDiameter;
    }

    /**
     * Sets the Oval's vertical diameter
     *
     * @param  newDiameter  An integer
     */
    public void setVerticalDiameter(int newDiameter)
    {
        verticalDiameter = newDiameter;
    }

    /**
     * Draws the Oval onto a canvas.
     * If the Oval isn't filled and doesn't
     * have an outline, then the Oval is drawn
     * as a black outline without a fill color.
     *
     * @param canvas  The Graphics plane which the Oval
     *                 is drawn on.
     */
    public void draw(Graphics canvas)
    {
        if(isOutlined()) {
            canvas.setColor(getOutlineColor());
            canvas.drawOval(getXPosition(), getYPosition(),
                    horizontalDiameter + OUTLINE_WIDTH, verticalDiameter + OUTLINE_WIDTH);
        }
        else if(!isFilled()){
            canvas.setColor(Color.BLACK);
            canvas.drawOval(getXPosition(), getYPosition(),
                    horizontalDiameter + OUTLINE_WIDTH, verticalDiameter + OUTLINE_WIDTH);
        }

        if(isFilled()){
            canvas.setColor(getFillColor());
        }
        else{
            canvas.setColor(canvas.getColor());
        }
        canvas.fillOval(getXPosition(), getYPosition(),
                horizontalDiameter, verticalDiameter);
    }

}
