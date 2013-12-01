package renderer.modelManager.polygon;

import extendedTypes.polygon.Poly2d;

/**
 *
 * @author main
 */
public class Poly2dStack {
    private final int size;
    private final Poly2d[] polyStack;
    private int pointer = 0;

    public Poly2dStack(int size) {
        this.size = size;
        this.polyStack = new Poly2d[size];
    }

    public void push(Poly2d poly) {
        if (pointer < size) {
            this.polyStack[pointer++] = poly;
        } else {
            System.err.println("PolyStack overflow.");
        }
    }

    public Poly2d pop() {
        if (pointer > 0) {
            return this.polyStack[--pointer];
        } else {
            System.err.println("PolyStack underflow");
            return new Poly2d();
        }
    }
}
