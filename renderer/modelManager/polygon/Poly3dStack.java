package renderer.modelManager.polygon;

import extendedTypes.polygon.Poly3d;

/**
 *
 * @author main
 */
public class Poly3dStack {

    private final int size;
    private final Poly3d[] polyBuffer;
    private int pointer = 0;

    public Poly3dStack(int size) {
        this.size = size;
        this.polyBuffer = new Poly3d[size];
    }

    public void push(Poly3d poly) {
        if (pointer < size) {
            this.polyBuffer[pointer++] = poly;
        } else {
            System.err.println("PolyStack overflow.");
        }
    }

    public Poly3d pop() {
        if (pointer > 0) {
            return this.polyBuffer[--pointer];
        } else {
            System.err.println("PolyStack underflow");
            return new Poly3d();
        }
    }
}
