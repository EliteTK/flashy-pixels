package extended.type.vector;

/**
 * Vector in 3 dimensions
 */
public class Vec3d {

    double x1, x2, x3;

    //Clean vector
    public Vec3d() {
        this.x1 = 0;
        this.x2 = 0;
        this.x3 = 0;
    }

    //Vector from values
    public Vec3d(double x1, double x2, double x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    //Vector from vector
    public Vec3d(Vec3d vec) {
        this.x1 = vec.x1;
        this.x2 = vec.x2;
        this.x3 = vec.x3;
    }

    //Vector from array
    public Vec3d(double[][] array) {
        if (array.length >= 3 && array[0].length == 1) {
            this.x1 = array[0][0];
            this.x2 = array[1][0];
            this.x3 = array[2][0];
        } else if (array.length == 1 && array[0].length >= 3) {
            this.x1 = array[0][0];
            this.x2 = array[0][1];
            this.x3 = array[0][2];
        } else {
            throw new IllegalArgumentException("Incorrect matrix dimensions");
        }
    }

    public Vec3d(double[] array) {
        if (array.length >= 3) {
            this.x1 = array[0];
            this.x2 = array[1];
            this.x3 = array[2];
        } else {
            throw new IllegalArgumentException("Incorrect matrix dimensions");
        }
    }

    public double[][] matrixCol() {
        double[][] mat = {{this.x1}, {this.x2}, {this.x3}};
        return mat;
    }

    public double[][] matrixRow() {
        double[][] mat = {{this.x1, this.x2, this.x3}};
        return mat;
    }

    /**
     *
     * @param x1
     * @param x2
     * @param x3 Sets the values of this to 3 new values.
     */
    public void setValue(double x1, double x2, double x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    /**
     *
     * @param vec Sets the value of this to another vector.
     */
    public void setValue(Vec3d vec) {
        this.x1 = vec.x1;
        this.x2 = vec.x2;
        this.x3 = vec.x3;
    }

    /**
     *
     * @param array Sets the values of this to the 3 values of a length 3+
     * array.
     */
    public void setValue(double[] array) {
        this.x1 = array[0];
        this.x2 = array[1];
        this.x3 = array[3];
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Vector subtraction: vec1 - vec2 .
     */
    public static Vec3d subtract(Vec3d vec1, Vec3d vec2) {
        return new Vec3d((vec1.x1 - vec2.x1), (vec1.x2 - vec2.x2), (vec1.x3 - vec2.x3));
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Vector addition: vec1 + vec2 .
     */
    public static Vec3d add(Vec3d vec1, Vec3d vec2) {
        return new Vec3d((vec1.x1 + vec2.x1), (vec1.x2 + vec2.x2), (vec1.x3 + vec2.x3));
    }

    /**
     *
     * @param vec
     * @return Length of vector vec.
     */
    public static double length(Vec3d vec) {
        return Math.sqrt((vec.x1 * vec.x1) + (vec.x2 * vec.x2) + (vec.x3 * vec.x3));
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Dot (scalar) product of vec1 and vec2.
     */
    public static double dot(Vec3d vec1, Vec3d vec2) {
        return (vec1.x1 * vec2.x1) + (vec1.x2 * vec2.x2) + (vec1.x3 * vec2.x3);
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Cross (vector) product of vec1 and vec2.
     */
    public static Vec3d cross(Vec3d vec1, Vec3d vec2) {
        double i, j, k;
        i = (vec1.x2 * vec2.x3 - vec1.x3 * vec2.x2);
        j = (vec1.x3 * vec2.x1 - vec1.x1 * vec2.x3);
        k = (vec1.x1 * vec2.x2 - vec1.x2 * vec2.x1);
        return new Vec3d(i, j, k);
    }

    /**
     *
     * @param vec
     * @return The normalized vector of vec. (sets length to 1)
     */
    public static Vec3d normalize(Vec3d vec) {
        double length = length(vec);
        return new Vec3d(vec.x1 / length, vec.x2 / length, vec.x3 / length);
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @param vec3
     * @return Takes the normal to 3 positional vectors.
     */
    public static Vec3d normal(Vec3d vec1, Vec3d vec2, Vec3d vec3) {
        return new Vec3d(normalize(cross(subtract(vec2, vec1), subtract(vec3, vec1))));
    }
}
