package renderer.window;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author main
 */
public class Window extends Canvas {

    JFrame frame;
    public int width;
    public int height;
    public String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        Dimension size;
        size = new Dimension(width, height);

        setPreferredSize(size);
    }

    public void createFrame() {
        frame = new JFrame();

        frame.setResizable(false);
        frame.setTitle(this.title);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
