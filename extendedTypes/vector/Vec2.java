package extendedTypes.vector;

public class Vec2 {

    float x1 = (float) 0.0, x2 = (float) 0.0;

    public Vec2() {

    }

    public Vec2(float x1, float x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Vec2(Vec2 vec2) {
        this.x1 = vec2.x1;
        this.x2 = vec2.x2;
    }

    public void setValue(float x1, float x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public void setValue(Vec2 vec2) {
        this.x1 = vec2.x1;
        this.x2 = vec2.x2;
    }

    public float length() {
        return (float) Math.sqrt(x1 * x1 + x2 * x2);
    }

    public static Vec2 add(Vec2 vec1, Vec2 vec2) {
        Vec2 vec3 = new Vec2();
        vec3.x1 = vec1.x1 + vec2.x1;
        vec3.x2 = vec1.x2 + vec2.x2;
        return vec3;
    }

    public static Vec2 sub(Vec2 vec1, Vec2 vec2) {
        Vec2 vec3 = new Vec2();
        vec3.x1 = vec1.x1 - vec2.x1;
        vec3.x2 = vec1.x2 - vec2.x2;
        return vec3;
    }

    public static Vec2 normalize(Vec2 vec) {
        float length = vec.length();
        vec.x1 = vec.x1 / length;
        vec.x2 = vec.x2 / length;
        return vec;
    }
}
