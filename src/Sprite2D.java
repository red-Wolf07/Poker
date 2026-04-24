import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Sprite2D class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/23/26)
 */
public class Sprite2D extends Shape2D_P7{

    private BufferedImage[] imageFrames;
    private int frame;

    public Sprite2D(int xPosition, int yPosition, BufferedImage[] imageFrames)
    {
        super(xPosition, yPosition);

        this.imageFrames = imageFrames;
        frame = 0;

        setYScale(-1.0);
    }

    public void draw(Graphics canvas)
    {
        canvas.drawImage(imageFrames[frame], 0, 0, null);
        frame = frame == imageFrames.length-1 ? 0 : frame + 1;
    }
}
