import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import java.util.List;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * CanvasPanel Class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/14/2026)
 */
public class CanvasPanel extends JPanel{

    private static final int X_CORNER = 10;
    private static final int Y_CORNER = 10;
    private static final int CANVAS_HEIGHT = 400;
    private static final int CANVAS_WIDTH = 400;
    private final Controls controls = new Controls();

    private List<Shape2D> shapes;
    private int frameNumber;

    private boolean action;

    public CanvasPanel()
    {
        super();
        action = false;
        frameNumber = 0;

        shapes = new ArrayList<Shape2D>();

        shapes.add(new Circle2D(Shape2D.YELLOW,30, 0, 30)); // eye
        shapes.add(new Circle2D(Shape2D.BLUE,30, 30, 30));

        shapes.add(new Rectangle2D(Shape2D.BLUE, 145, 120, 100, 140)); // head
        shapes.add(new Rectangle2D(Shape2D.CYAN, 185, 180, 20, 20)); // nose

        shapes.add(new Oval2D(Shape2D.YELLOW, 200, 210, 40, 20)); // eye
        shapes.add(new Oval2D(Shape2D.YELLOW, 150, 210, 40, 20)); // eye
        shapes.add(new Rectangle2D(Shape2D.RED, 165, 150, 60, 20)); // mouth

        shapes.add(new Circle2D(Shape2D.BLACK,160, 213, 15)); // eye
        shapes.add(new Circle2D(Shape2D.BLACK,215, 213, 15));

        this.setFocusable(true);
        this.addKeyListener(controls);

        Timer renderLoop = new Timer(30, (ActionEvent event) -> {frameNumber++; simulate(); repaint();});
        renderLoop.start();
    }

    public void simulate()
    {
        implementControls();
        if(action){
            shapes.get(0).move(5, 0);
            shapes.get(1).move(6, 0);
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

        Graphics2D canvas = setUpBackground(frame);

        canvas.translate(X_CORNER, (Y_CORNER + CANVAS_HEIGHT));
        canvas.scale(1, -1);

        for(Shape2D shape : shapes)
        {
            shape.draw(canvas);
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
