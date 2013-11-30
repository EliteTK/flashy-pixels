/**
 * IMPORTANT: THIS CLASS IS NOT MINE... IT WILL SOON BECOME REPLACED BY ONE
 * ENTIRELY WRITTEN BY ME. I ONCE MADE THE MISTAKE OF DELETING THE ONE I WROTE
 * AND REPLACING IT WITH THIS. UNFORTUNATELY THAT'S NO LEARNING EXPERIENCE.
 */
package extendedTypes.vector;

/**
 * Vector in 3 dimensions
 */
public class Vec3 {

    float x1 = (float) 0.0, x2 = (float) 0.0, x3 = (float) 0.0;

    /**
     * Simply creates instance, components initialised to
     * <tt>(float)0.0</tt>
     */
    public Vec3() {
        //vector already set to (0.0,0.0,0.0)
    }

    public Vec3(float xx1, float xx2, float xx3) {
        x1 = xx1;
        x2 = xx2;
        x3 = xx3;
    }

    public void setValue(float xx1, float xx2, float xx3) {
        x1 = xx1;
        x2 = xx2;
        x3 = xx3;
    }

    public void setValue(Vec3 a) {
        x1 = a.x1;
        x2 = a.x2;
        x3 = a.x3;
    }

    public void setValueRelative(float xx1, float xx2, float xx3) {
        x1 = x1 + xx1;
        x2 = x2 + xx2;
        x3 = x3 + xx3;
    }

    /**
     * Sets <tt>Vec3 this</tt> to zero
     */
    public void setZero() {
        x1 = (float) 0.0;
        x2 = (float) 0.0;
        x3 = (float) 0.0;
    }

    /**
     * Add and accumulate. <tt>Vec3 a</tt> is added to
     * <tt>Vec3 this</tt>
     */
    public void accAdd(Vec3 a) {
        x1 = x1 + a.x1;
        x2 = x2 + a.x2;
        x3 = x3 + a.x3;
    }

    /**
     * Subtract and accumulate. <tt>Vec3 a</tt> is subtracted from
     * <tt>Vec3 this</tt>
     */
    public void accSub(Vec3 a) {
        x1 = x1 - a.x1;
        x2 = x2 - a.x2;
        x3 = x3 - a.x3;
    }

    public static float dot(Vec3 a, Vec3 b) {
        return (a.x1 * b.x1 + a.x2 * b.x2 + a.x3 * b.x3);
    }

    public void cross(Vec3 a, Vec3 b) {
        x1 = a.x2 * b.x3 - a.x3 * b.x2;
        x2 = a.x3 * b.x1 - a.x1 * b.x3;
        x3 = a.x1 * b.x2 - a.x2 * b.x1;
    }

    public void normal(Vec3 a, Vec3 b) {
        // this is normal to a and b
        float length;
        x1 = a.x2 * b.x3 - a.x3 * b.x2;
        x2 = a.x3 * b.x1 - a.x1 * b.x3;
        x3 = a.x1 * b.x2 - a.x2 * b.x1;
        length = this.length();
        x1 = x1 / length;
        x2 = x2 / length;
        x3 = x3 / length;
    }

    /**
     * Calculate unit normal to triangle given by position vectors a, b and c in
     * the sense that a->b->c goes right-handed around n. For example, if a, b
     * and c are clockwise and flat in the plane of view, n is away from the
     * viewer.<p>
     * Alternatively, this is (b-a) cross (c-a) normalised.
     */
    public void normal(Vec3 a, Vec3 b, Vec3 c) {
        x1 = (b.x2 - a.x2) * (c.x3 - a.x3) - (b.x3 - a.x3) * (c.x2 - a.x2);
        x2 = (b.x3 - a.x3) * (c.x1 - a.x1) - (b.x1 - a.x1) * (c.x3 - a.x3);
        x3 = (b.x1 - a.x1) * (c.x2 - a.x2) - (b.x2 - a.x2) * (c.x1 - a.x1);
        float length = this.length();
        x1 = x1 / length;
        x2 = x2 / length;
        x3 = x3 / length;
    }

    public void normalise(Vec3 a) {
        float length;
        length = a.length();
        a.x1 = a.x1 / length;
        a.x2 = a.x2 / length;
        a.x3 = a.x3 / length;
    }

    /**
     * Returns length of vector
     */
    public float length() {
        return ((float) Math.sqrt(x1 * x1 + x2 * x2 + x3 * x3));
    }

    /**
     * Returns length of vector squared
     */
    public float lengthSqd() {
        return (x1 * x1 + x2 * x2 + x3 * x3);
    }

    /**
     * Returns length of vector (b-a) squared
     */
    public static float distSqd(Vec3 a, Vec3 b) {
        return ((float) (a.x1 - b.x1) * (a.x1 - b.x1)
                + (a.x2 - b.x2) * (a.x2 - b.x2)
                + (a.x3 - b.x3) * (a.x3 - b.x3));
    }

}
