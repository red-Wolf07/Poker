/**
 * StarPolygon2D class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/23/26)
 */
public class StarPolygon2D extends Polygon2D{

    private static final int[] xCoordinates = { 0, 2, 10, 2, 0, -2, -10, -2};
    private static final int[] yCoordinates = {-10, -2, 0, 2, 10, 2, 0, -2};

    public StarPolygon2D(int colorIndex, int xPosition, int yPosition)
    {
        super(colorIndex, xPosition, yPosition, xCoordinates, yCoordinates);
    }


}
