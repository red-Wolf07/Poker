import java.awt.Graphics;
import java.awt.Color;

/**
 * Rectangle class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/16/2026)
 */
public class Rectangle2D_P7 extends Shape2D_P7{

    private static final int OUTLINE_WIDTH = 10;

    private int width;
    private int height;

    /**
     * Constructor for the Rectangle class
     * 'width, 'height', and other variables are
     * set to default values.
     */
    public Rectangle2D_P7()
    {
        super();
        width = 10;
        height = 10;
    }

    /**
     * Overloaded constructor for the Rectangle2D class
     * Sets the color, x and y positions, width, and height
     * to specified values.
     * Color is determined by a 'color index', available color
     * indices are in the Shape2D class.
     * Any other variables are set to default values.
     *
     * @param  colorIndex   An integer
     * @param  xPosition    An integer
     * @param  yPosition    An integer
     * @param  width        An integer
     * @param  height       An integer
     */
    public Rectangle2D_P7(int colorIndex, int xPosition, int yPosition, int width, int height)
    {
        super(colorIndex, xPosition, yPosition);
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the Rectangle's width
     *
     * @return    The value of the width variable
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Gets the Rectangle's height
     *
     * @return    The value of the height variable
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Sets the Rectangle's width
     *
     * @param  width  An integer
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Sets the Rectangle's height
     *
     * @param  height  An integer
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Draws the Rectangle onto a canvas.
     * If the Rectangle isn't filled and doesn't
     * have an outline, then the Rectangle is drawn
     * as a black outline without a fill color.
     *
     * @param  canvas  The Graphics plane which the Rectangle
     *                 is drawn on.
     */
    public void draw(Graphics canvas)
    {
        if(isOutlined()) {
            canvas.setColor(getOutlineColor());
            canvas.drawRect(0, 0,
                    width + OUTLINE_WIDTH, height + OUTLINE_WIDTH);
        }
        else if(!isFilled()){
            canvas.setColor(Color.BLACK);
            canvas.drawRect(0, 0,
                    width + OUTLINE_WIDTH, height + OUTLINE_WIDTH);
        }

        if(isFilled()){
            canvas.setColor(getFillColor());
        }
        else{
            canvas.setColor(canvas.getColor());
        }
        canvas.fillRect(0, 0,
                        width, height);
    }
}
