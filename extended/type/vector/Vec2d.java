package extended.type.vector;

public class Vec2d {

    double x1, x2;

    public Vec2d() {
        this.x1 = 0;
        this.x2 = 0;
    }

    public Vec2d(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Vec2d(Vec2d vec2) {
        this.x1 = vec2.x1;
        this.x2 = vec2.x2;
    }

    public void setValue(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public void setValue(Vec2d vec) {
        this.x1 = vec.x1;
        this.x2 = vec.x2;
    }

    public static double length(Vec2d vec) {
        return Math.sqrt(vec.x1 * vec.x1 + vec.x2 * vec.x2);
    }

    public static Vec2d add(Vec2d vec1, Vec2d vec2) {
        Vec2d vec3 = new Vec2d();
        vec3.x1 = vec1.x1 + vec2.x1;
        vec3.x2 = vec1.x2 + vec2.x2;
        return vec3;
    }

    public static Vec2d subtract(Vec2d vec1, Vec2d vec2) {
        Vec2d vec3 = new Vec2d();
        vec3.x1 = vec1.x1 - vec2.x1;
        vec3.x2 = vec1.x2 - vec2.x2;
        return vec3;
    }

    public static Vec2d normalize(Vec2d vec) {
        double length = Vec2d.length(vec);
        vec.x1 = vec.x1 / length;
        vec.x2 = vec.x2 / length;
        return vec;
    }
}
