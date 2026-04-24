import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * CanvasFrame Class
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/14/2026)
 */
public class CanvasFrame extends JFrame{

    private JFrame frame;
    private CanvasPanel canvas;

    /**
     * Constructor for the CanvasFrame class
     */
    public CanvasFrame()
    {
        frame = new JFrame("Jason Hicks - OOPDA 2026 Project6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new CanvasPanel();
        canvas.setPreferredSize(new Dimension((canvas.getCanvasXCorner() * 2) + CanvasPanel.getCanvasWidth(),
                                                (canvas.getCanvasYCorner() * 2) + CanvasPanel.getCanvasWidth()));

        frame.getContentPane().add(canvas);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
