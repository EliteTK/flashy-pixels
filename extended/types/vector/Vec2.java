package extended.types.vector;

public class Vec2 {

    double x1, x2;

    public Vec2() {
        this.x1 = 0;
        this.x2 = 0;
    }

    public Vec2(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Vec2(Vec2 vec2) {
        this.x1 = vec2.x1;
        this.x2 = vec2.x2;
    }

    public void setValue(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public void setValue(Vec2 vec) {
        this.x1 = vec.x1;
        this.x2 = vec.x2;
    }

    public static double length(Vec2 vec) {
        return Math.sqrt(vec.x1 * vec.x1 + vec.x2 * vec.x2);
    }

    public static Vec2 add(Vec2 vec1, Vec2 vec2) {
        Vec2 vec3 = new Vec2();
        vec3.x1 = vec1.x1 + vec2.x1;
        vec3.x2 = vec1.x2 + vec2.x2;
        return vec3;
    }

    public static Vec2 subtract(Vec2 vec1, Vec2 vec2) {
        Vec2 vec3 = new Vec2();
        vec3.x1 = vec1.x1 - vec2.x1;
        vec3.x2 = vec1.x2 - vec2.x2;
        return vec3;
    }

    public static Vec2 normalize(Vec2 vec) {
        double length = Vec2.length(vec);
        vec.x1 = vec.x1 / length;
        vec.x2 = vec.x2 / length;
        return vec;
    }
}
