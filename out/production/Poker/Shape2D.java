import java.awt.Color;
import java.awt.Graphics;

/**
 * Shape2D class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/10/26)
 */
public abstract class Shape2D {

    public final static int RED = 0;
    public final static int GREEN = 1;
    public final static int BLUE = 2;
    public final static int BLACK = 3;
    public final static int GREY = 4;
    public final static int WHITE = 5;
    public final static int YELLOW = 6;
    public final static int CYAN = 7;
    public final static int MAGENTA = 8;
    public final static int BROWN = 9;

    public static final Color[] COLORS = {
            new Color(255, 0, 0), // Red 0
            new Color( 0, 255, 0), // Green 1
            new Color( 0, 0, 255), // Blue 2
            new Color( 0, 0, 0), // Black 3
            new Color(128, 128, 128), // Grey 4
            new Color(255, 255, 255), // White 5
            new Color(255, 255, 0), // Yellow 6
            new Color( 0, 255, 255), // Cyan 7
            new Color(255, 0, 255), // Magenta 8
            new Color(165, 42, 42), // Brown 9
            new Color(255, 38, 38),
            new Color(255, 168, 38),
            new Color(212, 255, 38),
            new Color( 82, 255, 38),
            new Color( 38, 255, 125),
            new Color( 38, 255, 255),
            new Color( 38, 125, 255),
            new Color( 82, 38, 255),
            new Color(212, 38, 255),
            new Color(255, 38, 168)
    };

    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;
    private Color fillColor;
    private int fillColorIndex;
    private Color outlineColor;
    private int outlineColorIndex;
    private boolean fill;
    private boolean outline;

    /**
     * Main Constructor for the Shape2D class
     * Initializes all fields to default values
     */
    public Shape2D()
    {
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;

        fill = true;
        outline = false;

        fillColorIndex = GREEN;
        fillColor = COLORS[fillColorIndex];

        outlineColorIndex = BLACK;
        outlineColor = COLORS[outlineColorIndex];

    }

    /**
     * Overloaded Constructor for the Shape2D class
     * Creates a shape with a specified color index
     *
     * @param  colorIndex  An int value
     */
    public Shape2D(int colorIndex)
    {
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;

        fillColorIndex = colorIndex;
        fillColor = COLORS[colorIndex];

        outlineColorIndex = colorIndex;
        outlineColor = COLORS[colorIndex];

        fill = true;
        outline = false;
    }

    /**
     * Overloaded Constructor for the Shape2D class
     * Creates a shape with a specified color
     *
     * @param  color  A Color
     */
    public Shape2D(Color color)
    {
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;

        setFillColor(color);
        setOutlineColor(color);

        fill = true;
        outline = false;
    }

    /**
     * Overloaded Constructor for the Shape2D class
     * Creates a shape at a specified position
     *
     * @param  xPosition
     * @param  yPosition
     */
    public Shape2D(int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        xVelocity = 0;
        yVelocity = 0;

        fill = true;
        outline = false;

        fillColorIndex = GREEN;
        fillColor = COLORS[fillColorIndex];

        outlineColorIndex = BLACK;
        outlineColor = COLORS[outlineColorIndex];

    }

    /**
     * Overloaded Constructor for the Shape2D class
     * Creates a shape with a specified color, at a specified
     * position
     *
     * @param  colorIndex
     * @param  xPosition
     * @param  yPosition
     */
    public Shape2D(int colorIndex, int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        xVelocity = 0;
        yVelocity = 0;

        fillColorIndex = colorIndex;
        fillColor = COLORS[colorIndex];

        outlineColorIndex = colorIndex;
        outlineColor = COLORS[colorIndex];

        fill = true;
        outline = false;
    }

    /**
     * Gets the Shape's x-position
     *
     * @return     The integer value of xPosition
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Gets the Shape's y-position
     *
     * @return     The integer value of yPosition
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * Gets the Shape's x-velocity
     *
     * @return     The integer value of xVelocity
     */
    public int getXVelocity()
    {
        return xVelocity;
    }

    /**
     * Gets the Shape's y-velocity
     *
     * @return     The integer value of yVelocity
     */
    public int getYVelocity()
    {
        return yVelocity;
    }

    /**
     * Gets the index of the Shape's outline color
     *
     * @return     The integer value of outlineColorIndex
     */
    public int getOutlineColorIndex()
    {
        return outlineColorIndex;
    }

    /**
     * Gets the index of the Shape's fill color
     *
     * @return     The integer value of fillColorIndex
     */
    public int getFillColorIndex()
    {
        return fillColorIndex;
    }

    /**
     * Gets the Shape's outline color
     *
     * @return     A Color object representing the shape's outlineColor
     */
    public Color getOutlineColor()
    {
        return outlineColor;
    }

    /**
     * Gets the Shape's fill color
     *
     * @return     A Color object representing the shape's fillColor
     */
    public Color getFillColor()
    {
        return fillColor;
    }

    /**
     * Checks if the shape is filled in
     *
     * @return     true if the shape will be filled in when drawn
     *             false if the shape will not be filled in
     */
    public boolean isFilled()
    {
        return fill;
    }

    /**
     * Checks if the shape has an outline
     *
     * @return     true if the shape will have an outline when drawn
     *             false if the shape will not have an outline
     */
    public boolean isOutlined()
    {
        return outline;
    }

    /**
     * Sets the Shape's current x-position to a new one
     *
     * @param  xPos  An integer
     */
    public void setXPosition(int xPos)
    {
        xPosition = xPos;
    }

    /**
     * Sets the Shape's current y-position to a new one
     *
     * @param  yPos  An integer
     */
    public void setYPosition(int yPos)
    {
        yPosition = yPos;
    }

    /**
     * Sets the Shape's current x-velocity to a new one
     *
     * @param  xVel  An integer
     */
    public void setXVelocity(int xVel)
    {
        xVelocity = xVel;
    }

    /**
     * Sets the Shape's current y-velocity to a new one
     *
     * @param  yVel  An integer
     */
    public void setYVelocity(int yVel)
    {
        yVelocity = yVel;
    }

    /**
     * Sets the Shape's current outline color index to a new one
     * and changes the outline color of the Shape
     *
     * @param  outlineIndex  An integer
     */
    public void setOutlineColorIndex(int outlineIndex)
    {
        outlineColorIndex = outlineIndex;
        outlineColor = COLORS[outlineColorIndex];
    }

    /**
     * Sets the Shape's current fill color index to a new one
     * and changes the fill color of the Shape
     *
     * @param  fillIndex  An integer
     */
    public void setFillColorIndex(int fillIndex)
    {
        fillColorIndex = fillIndex;
        fillColor = COLORS[fillColorIndex];
    }

    /**
     * Sets the Shape's current outline color to a new one
     * this changes outline color index to reflect this.
     * NOTE: If the new color doesn't appear in COLORS then
     * outlineColorIndex = -1
     *
     * @param  color  A color object
     */
    public void setOutlineColor(Color color)
    {
        outlineColor = color;
        boolean isMatch = false;

        for(int i = 0; i < COLORS.length; i++)
        {
            if(outlineColor.equals(COLORS[i])){
                outlineColorIndex = i;
                isMatch = true;
            }
        }

        if(!isMatch){
            outlineColorIndex = -1;
        }
    }

    /**
     * Sets the Shape's current outline color index to a new one
     * this changes fill color index to reflect this.
     * NOTE: If the new color doesn't appear in COLORS then
     * fillColorIndex = -1
     *
     * @param  color  A color object
     */
    public void setFillColor(Color color)
    {
        fillColor = color;
        boolean isMatch = false;

        for(int i = 0; i < COLORS.length; i++)
        {
            if(fillColor.equals(COLORS[i])){
                fillColorIndex = i;
                isMatch = true;
            }
        }

        if(!isMatch){
            fillColorIndex = -1;
        }
    }

    /**
     * Changes weather or not the shape is filled in.
     *
     * @param  isFilled  A boolean, If true: the shape will be filled in
     *                              If false: the shape will be hollow
     */
    public void setFill(boolean isFilled)
    {
        fill = isFilled;
    }

    /**
     * Changes weather or not the shape has an outline.
     *
     * @param  isOutlined  A boolean, If true: the shape will have an outline
     *                                If false: it won't
     */
    public void setOutline(boolean isOutlined)
    {
        outline = isOutlined;
    }

    /**
     * Moves the shape by its x and y velocity
     */
    public void move()
    {
        xPosition += xVelocity;
        yPosition += yVelocity;
    }

    /**
     * Moves the shape by a specified x and y value
     *
     * @param  deltaX  An integer
     * @param  deltaY  An integer
     */
    public void move(int deltaX, int deltaY)
    {
        xPosition += deltaX;
        yPosition += deltaY;
    }

    /**
     * Draws the shape onto a canvas
     *
     * @param  canvas  The Graphics plane which the shape
     *                 is drawn on.
     */
    public abstract void draw(Graphics canvas);

}
