import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import javax.swing.Timer;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 * CanvasPanel Class
 *
 * @author (Jason Hicks)
 * @version (v1.1 - 04/23/2026)
 */
public class CanvasPanel extends JPanel{

    private static final int X_CORNER = 10;
    private static final int Y_CORNER = 10;
    private static final int CANVAS_HEIGHT = 600;
    private static final int CANVAS_WIDTH = 1000;
    private final Controls controls = new Controls();

    private List<Shape2D> shapes;
    private Shape2D selectedShape;
    private int frameNumber;

    private final static int STAR_2 = 6;
    private final static int SUN = 8;
    private final static int BLUE_CIRCLE = 16;
    private final static int CYAN_CIRCLE = 17;
    private final static int BLUE_RECT = 18;
    private final static int SONIC_SPRITE_1 = 19;

    private boolean action;

    public CanvasPanel()
    {
        super();
        action = false;
        frameNumber = 0;

        shapes = new ArrayList<Shape2D>();
        selectedShape = null;



        this.setFocusable(true);
        this.addKeyListener(controls);

        Timer renderLoop = new Timer(30, (ActionEvent event) -> {frameNumber++; simulate(); repaint();});
        renderLoop.start();
    }

    public void simulate()
    {
        implementControls();
        if(action){
            Shape2D shape = null;

        }
    }

    public void implementControls()
    {
        switch(controls.getCurrentKey())
        {
            case KeyEvent.VK_ENTER:
                action = !action;
        }
    }

    @Override
    public void paintComponent(Graphics frame)
    {
        super.paintComponent(frame);

        Graphics2D canvas = (Graphics2D) setUpBackground(frame).create();

        canvas.translate(X_CORNER, (Y_CORNER + CANVAS_HEIGHT));
        canvas.scale(1, -1);

        for(Shape2D shape : shapes)
        {
            AffineTransform savedTransform = canvas.getTransform();
            shape.transform(canvas);
            shape.draw(canvas);
            canvas.setTransform(savedTransform);
        }
    }

    private Graphics2D setUpBackground(Graphics frame)
    {
        Graphics2D backgroundGraphics = (Graphics2D) frame.create();
        backgroundGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        backgroundGraphics.setColor(new Color(125, 60,10));
        backgroundGraphics.fillRect(0, 0, CANVAS_WIDTH + (2 * X_CORNER),
                                                CANVAS_HEIGHT + (2 * Y_CORNER));

        backgroundGraphics.setColor(new Color(92, 196, 68));
        backgroundGraphics.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT);

       return backgroundGraphics;
    }

    /**
     * Gets the height of the canvas
     *
     * @return    The int value of CANVAS_HEIGHT
     */
    public static int getCanvasHeight()
    {
        return CANVAS_HEIGHT;
    }

    /**
     * Gets the width of the canvas
     *
     * @return    The int value of CANVAS_WIDTH
     */
    public static int getCanvasWidth()
    {
        return CANVAS_WIDTH;
    }

    /**
     *
     *
     * @return    The int value of X_CORNER
     */
    public static int getCanvasXCorner()
    {
        return X_CORNER;
    }

    /**
     *
     *
     * @return    The int value of Y_CORNER
     */
    public static int getCanvasYCorner()
    {
        return Y_CORNER;
    }

}
