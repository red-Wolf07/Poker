import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Controls class
 * LISTENS FOR INPUTS - implementation for each
 * key is up to the class using it.
 *
 * @author (Jason Hicks)
 * @version (v1.0 - 04/16/2026)
 */
public class Controls extends KeyAdapter{

    private int currentKey;

    @Override
    public void keyPressed(KeyEvent event)
    {
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(event.getKeyCode()));
        currentKey = event.getKeyCode();
    }

    public void keyReleased(KeyEvent event)
    {
        System.out.println("Key Released: " + KeyEvent.getKeyText(event.getKeyCode()));
    }

    public int getCurrentKey()
    {
        int temporaryKey = currentKey;
        currentKey = 0;

        return temporaryKey;
    }


}
