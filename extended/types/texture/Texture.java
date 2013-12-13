package extended.types.texture;

import extended.types.colour.Colour;

public class Texture {

    private final Colour[][] texture;
    int width;
    int height;

    public Texture(int width, int height) {
        this.texture = new Colour[width][height];
        this.width = width;
        this.height = height;

    }

    /**
     *
     * @param x
     * @param y
     * @return Colour at X,Y position on Texture.
     */
    public Colour getColourFromPos(int x, int y) {
        if ((x >= 0) && (x < width)) {
            if ((y >= 0) && (y < height)) {
                return (Colour) texture[x][y];
            }
        }
        throw new RuntimeException("Colour query out of bounds.");
    }

    /**
     * Bilinear interpolator for sampling textures.
     * @param x
     * @param y
     * @return Return bilinearly interpolated colour value estimate at X,Y.
     */
    public Colour getColourInterpolate(double x, double y) {

        if ((x < 0) || (x > width) || (y < 0) || (y > height)) {
            throw new RuntimeException("Colour sampling location out of bounds.");
        }

        /**
         * Create variables for storing 2 of the initial horizontal interpoles
         * and then the final interpole interpolating them both vertically
         */
        Colour interpoleX1;
        Colour interpoleX2;
        Colour interpoleY;

        x -= 0.5;
        y -= 0.5;

        if (x < 0) {
            x = 0;
        } else if (x > width) {
            x = width;
        }
        if (y < 0) {
            y = 0;
        } else if (y > height) {
            y = height;
        }

        double xFloor = Math.floor(x);
        double xCeil = Math.ceil(x);

        double yFloor = Math.floor(y);
        double yCeil = Math.ceil(y);

        if (xCeil > width) {
            xCeil = width;
        }

        if (yCeil > height) {
            yCeil = height;
        }

        double xMod = x % 1;
        double yMod = y % 1;

        Colour x1FloorColour = this.getColourFromPos((int) xFloor, (int) yFloor);
        Colour x1CeilColour = this.getColourFromPos((int) xCeil, (int) yFloor);
        Colour x2FloorColour = this.getColourFromPos((int) xFloor, (int) yCeil);
        Colour x2CeilColour = this.getColourFromPos((int) xCeil, (int) yCeil);

        if (xMod == 0.0) {
            interpoleX1 = this.getColourFromPos((int) xFloor, (int) yFloor);
            interpoleX2 = this.getColourFromPos((int) xFloor, (int) yCeil);
        } else {

        }
        return new Colour();
    }
}
