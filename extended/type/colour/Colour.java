package extended.type.colour;

public final class Colour {

    private byte R = -128;
    private byte G = -128;
    private byte B = -128;
    private byte A = -128;

    public Colour() {

    }

    public Colour(int R, int G, int B) {
        this.setR(R);
        this.setG(G);
        this.setB(B);
    }

    public Colour(int R, int G, int B, int A) {
        this.setR(R);
        this.setG(G);
        this.setB(B);
        this.setA(A);
    }

    public int getR() {
        return R + 128;
    }

    public void setR(int r) {
        R = (byte) (r - 128);
    }

    public int getG() {
        return G + 128;
    }

    public void setG(int g) {
        G = (byte) (g - 128);
    }

    public int getB() {
        return B + 128;
    }

    public void setB(int b) {
        B = (byte) (b - 128);
    }

    public int getA() {
        return A + 128;
    }

    public void setA(int a) {
        A = (byte) (a - 128);
    }

}
