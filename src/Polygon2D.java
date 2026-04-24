import java.awt.Graphics;
import java.awt.Color;

/**
 * Polygon2D class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/23/26)
 */
public class Polygon2D extends Shape2D_P7{

    private int[] xCoordinates;
    private int[] yCoordinates;

    public Polygon2D(int colorIndex, int xPosition, int yPosition,
                     int[] xCoordinates, int[] yCoordinates)
    {
        super(colorIndex, xPosition, yPosition);

        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    public void draw(Graphics canvas)
    {
        if(isFilled()){
            canvas.setColor(getFillColor());
        }
        else{
            canvas.setColor(canvas.getColor());
        }
        canvas.fillPolygon(xCoordinates, yCoordinates, xCoordinates.length);

        if(isOutlined()) {
            canvas.setColor(getOutlineColor());
            canvas.drawPolygon(xCoordinates, yCoordinates, xCoordinates.length);
        }
        else if(!isFilled()){
            canvas.setColor(Color.BLACK);
            canvas.drawPolygon(xCoordinates, yCoordinates, xCoordinates.length);
        }
    }

}
