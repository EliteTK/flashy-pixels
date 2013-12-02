package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import renderer.window.Window;

/**
 *
 * @author main
 */
public class Start {

    private static final int width = 320;
    private static final int height = 200;
    private static final int scale = 2;
    private static final int scaledWidth = width * scale;
    private static final int scaledHeight = height * scale;
    
    private static final String title = "Test";

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        Window window = new Window(scaledWidth, scaledHeight, title);
        window.frameInit();
        window.frame().setVisible(true);

        BufferedImage image;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int fps;

        while (true) {

            BufferStrategy bstrat;

            fps = (int) (1000000000 / delta());

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, (new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))).getRGB());
                    //image.setRGB(x, y, 0xDEADBE);
                }
            }
            
            window.frame().setTitle("Test   FPS: " + fps);
            
            Graphics g1 = image.getGraphics();
            {
                g1.setColor(new Color(40, 40, 40));
                g1.fillRect(10, 10, 59, 11);
                g1.setColor(new Color(255, 255, 40));
                g1.drawString("FPS " + String.valueOf(fps), 10, 20);
            }
            g1.dispose();

            window.drawImage(image);
        }
    }

    private static long deltaLast = 0;

    private static long delta() {
        long time = System.nanoTime();
        long delta = time - deltaLast;
        deltaLast = time;
        return delta;
    }

}
