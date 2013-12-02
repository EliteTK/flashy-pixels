package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import renderer.window.Window;

/**
 *
 * @author main
 */
public class Start2 {

    private static final int width = 320;
    private static final int height = 200;
    private static final String title = "Test";

    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));

        Window window = new Window(width, height, title);
        window.frameInit();
        window.frame().setVisible(true);

        int startX;
        int startY;
        int endX;
        int endY;

        while (true) {

            startX = (int) (Math.random() * width);
            startY = (int) (Math.random() * height);
            endX = (int) (Math.random() * width);
            endY = (int) (Math.random() * height);

            if (startX > endX) {
                int temp = startX;
                startX = endX;
                endX = temp;
            }

            if (startY > endY) {
                int temp = startY;
                startX = endY;
                endX = temp;
            }

            Graphics g = window.getGraphics();
            {
                g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
                g.fillRect(startX, startY, endX - startX + 1, endY - startY + 1);
            }
            g.dispose();
        }
    }
}
