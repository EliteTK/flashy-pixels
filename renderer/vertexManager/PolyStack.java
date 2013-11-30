package renderer.vertexManager;

import extendedTypes.polygon.Poly3;

/**
 *
 * @author main
 */
public class PolyStack {

    private final int size;
    private final Poly3[] polyBuffer;
    private int pointer = 0;

    public PolyStack(int size) {
        this.size = size;
        this.polyBuffer = new Poly3[size];
    }

    public void push(Poly3 poly) {
        if (pointer < size) {
            this.polyBuffer[pointer++] = poly;
        } else {
            System.err.println("PolyStack overflow.");
        }
    }

    public Poly3 pop() {
        if (pointer > 0) {
            return this.polyBuffer[--pointer];
        } else {
            System.err.println("PolyStack underflow");
            return new Poly3();
        }
    }
}
