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
    private static final int CANVAS_WIDTH = 600;
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

        int [] xCoords = {0, 150, 200, 300, 400, 500, 600};
        int [] yCoords = {165, 265, 235, 305, 225, 355, 165};
        shapes.add(new Polygon2D(Shape2D.BROWN, 0, 0, xCoords ,yCoords));

// Grass and road
        shapes.add(new Rectangle2D(Shape2D.GREEN, 0, 0, 600, 75));
        shapes.add(new Rectangle2D(Shape2D.BLACK, 0, 75, 600, 50));
        shapes.add(new Rectangle2D(Shape2D.WHITE, 0, 125, 600, 10));
        shapes.add(new Rectangle2D(Shape2D.BLACK, 0, 135, 600, 30));

// Stars
        shapes.add(new StarPolygon2D(6, 200, 500));

        selectedShape = new StarPolygon2D(6, 100, 300);
        selectedShape.setScale(1.2, 1.2);
        shapes.add(selectedShape);

        selectedShape = new StarPolygon2D(6, 500, 400);
        selectedShape.setScale(.8, .8);
        shapes.add(selectedShape);

        selectedShape = new Oval2D(Shape2D.YELLOW, 100, 400, 40, 30);
        selectedShape.setPivot(-50.0, -700.0);
        shapes.add(selectedShape);

// Create a blockhead from rectangles, circles and ovals
        shapes.add(new Rectangle2D(Shape2D.BLUE, 445, 420, 100,
                140)); // head, shape 9
        shapes.add(new Rectangle2D(Shape2D.CYAN, 485, 480, 20,
                20)); // nose, shape 10
        shapes.add(new Oval2D(Shape2D.YELLOW, 500, 510, 40,
                20)); // eye, shape 11
        shapes.add(new Oval2D(Shape2D.YELLOW, 450, 510, 40,
                20)); // eye, shape 12
        shapes.add(new Rectangle2D(Shape2D.RED, 465, 450, 60,
                20)); // mouth, shape 13
        shapes.add(new Circle2D(Shape2D.BLACK,460, 513,
                15)); // eye, shape 14
        shapes.add(new Circle2D(Shape2D.BLACK,515, 513,
                15)); // eye, shape 15
        shapes.add(new Circle2D());
        shapes.add(new Circle2D(Shape2D.CYAN, 20, 20, 40));
        shapes.add(new Rectangle2D(Shape2D.BLUE, 200, 135, 100, 50));

// Sonic Sprite
        BufferedImage[] Sonic_Sprites = new BufferedImage[4];
        try {
            Sonic_Sprites[0] = ImageIO.read(new File("H:\\OOPDA\\Projects\\Project7\\src\\Sonic1.png"));
            Sonic_Sprites[1] = ImageIO.read(new File("H:\\OOPDA\\Projects\\Project7\\src\\Sonic2.png"));
            Sonic_Sprites[2] = ImageIO.read(new File("H:\\OOPDA\\Projects\\Project7\\src\\Sonic3.png"));
            Sonic_Sprites[3] = ImageIO.read(new File("H:\\OOPDA\\Projects\\Project7\\src\\Sonic4.png"));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        Sprite2D sonic = new Sprite2D(100, 125, Sonic_Sprites);
        shapes.add(sonic); // shape 19

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

            shape = shapes.get(STAR_2);
            double angle = shape.getRotationAngleZ();
            angle += 1.0;
            shape.setRotationAngleZ(angle);

            shape = shapes.get(SUN);
            angle = shape.getRotationAngleZ();
            angle += 1.0;
            shape.setRotationAngleZ(angle);

            shape = shapes.get(CYAN_CIRCLE);
            shape.move(1, 2); // move the shape along via a delta in x and y

            shape = shapes.get(BLUE_CIRCLE);
            shape.move(2, 1); // move the shape along via a delta in x and y

            shape = shapes.get(BLUE_RECT);
            shape.move(2, 0); // move the shape along via a delta in x and y

            shape = shapes.get(SONIC_SPRITE_1);
            shape.move(3, 0); // move the shape along via a delta in x and y
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

        backgroundGraphics.setColor(Color.BLACK);
        backgroundGraphics.fillRect(0, 0, CANVAS_WIDTH + (2 * X_CORNER),
                                                CANVAS_HEIGHT + (2 * Y_CORNER));

        backgroundGraphics.setColor(Color.LIGHT_GRAY);
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
