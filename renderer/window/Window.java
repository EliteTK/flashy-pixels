package renderer.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author main
 */
public class Window extends Canvas {

    private final JFrame frame;
    private final int width;
    private final int height;
    private final String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        Dimension size;
        size = new Dimension(width, height);

        setPreferredSize(size);

        frame = new JFrame();
    }

    public void frameInit() {
        frame.setResizable(false);
        frame.setTitle(this.title);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    
    public JFrame frame() {
        return frame;
    }

    public void drawImage(Image image) {
        Graphics g;
        g = this.getGraphics();
        g.drawImage(image, 0, 0, width, height, this);
        g.dispose();
    }
}
