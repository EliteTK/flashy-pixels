package extendedTypes.vector;

/**
 * Vector in 3 dimensions
 */
public class Vec3 {

    double x1, x2, x3;

    //Clean vector
    public Vec3() {
        this.x1 = 0;
        this.x2 = 0;
        this.x3 = 0;
    }

    //Vector from values
    public Vec3(double x1, double x2, double x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    //Vector from vector
    public Vec3(Vec3 vec) {
        this.x1 = vec.x1;
        this.x2 = vec.x2;
        this.x3 = vec.x3;
    }

    //Vector from array
    public Vec3(double[] array) {
        this.x1 = array[0];
        this.x2 = array[1];
        this.x3 = array[3];
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
    public void setValue(Vec3 vec) {
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
    public static Vec3 subtract(Vec3 vec1, Vec3 vec2) {
        return new Vec3((vec1.x1 - vec2.x1), (vec1.x2 - vec2.x2), (vec1.x3 - vec2.x3));
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Vector addition: vec1 + vec2 .
     */
    public static Vec3 add(Vec3 vec1, Vec3 vec2) {
        return new Vec3((vec1.x1 + vec2.x1), (vec1.x2 + vec2.x2), (vec1.x3 + vec2.x3));
    }

    /**
     *
     * @param vec
     * @return Length of vector vec.
     */
    public static double length(Vec3 vec) {
        return Math.sqrt((vec.x1 * vec.x1) + (vec.x2 * vec.x2) + (vec.x3 * vec.x3));
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Dot (scalar) product of vec1 and vec2.
     */
    public static double dot(Vec3 vec1, Vec3 vec2) {
        return (vec1.x1 * vec2.x1) + (vec1.x2 * vec2.x2) + (vec1.x3 * vec2.x3);
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @return Cross (vector) product of vec1 and vec2.
     */
    public static Vec3 cross(Vec3 vec1, Vec3 vec2) {
        double i, j, k;
        i = (vec1.x2 * vec2.x3 - vec1.x3 * vec2.x2);
        j = (vec1.x3 * vec2.x1 - vec1.x1 * vec2.x3);
        k = (vec1.x1 * vec2.x2 - vec1.x2 * vec2.x1);
        return new Vec3(i, j, k);
    }

    /**
     *
     * @param vec
     * @return The normalized vector of vec. (sets length to 1)
     */
    public static Vec3 normalize(Vec3 vec) {
        double length = length(vec);
        return new Vec3(vec.x1 / length, vec.x2 / length, vec.x3 / length);
    }

    /**
     *
     * @param vec1
     * @param vec2
     * @param vec3
     * @return Takes the normal to 3 positional vectors.
     */
    public static Vec3 normal(Vec3 vec1, Vec3 vec2, Vec3 vec3) {
        return new Vec3(normalize(cross(subtract(vec2, vec1), subtract(vec3, vec1))));
    }
}
