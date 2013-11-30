package extendedTypes.polygon;

import extendedTypes.vector.Vec3;

public class Poly3 {

    private Vec3 vec1 = new Vec3(0, 0, 0);
    private Vec3 vec2 = new Vec3(0, 0, 0);
    private Vec3 vec3 = new Vec3(0, 0, 0);
    private Vec3 colour = new Vec3(0, 0, 0);
    private Vec3 normal = new Vec3(0, 0, 0);

    public Poly3() {

    }

    public Poly3(Vec3 vec1, Vec3 vec2, Vec3 vec3) {
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.vec3 = vec3;
        this.normal = Vec3.normal(this.vec1, this.vec2, this.vec3);
    }

    public Poly3(Vec3 vec1, Vec3 vec2, Vec3 vec3, Vec3 colour) {
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.vec3 = vec3;
        this.colour = colour;
        this.normal = Vec3.normal(this.vec1, this.vec2, this.vec3);
    }

    public void setVec1(Vec3 newVec) {
        this.vec1 = newVec;
    }

    public void setVec2(Vec3 newVec) {
        this.vec2 = newVec;
    }

    public void setVec3(Vec3 newVec) {
        this.vec3 = newVec;
    }

    public void setColour(Vec3 newColour) {
        this.colour = newColour;
    }

    public void setNormal(Vec3 newNormal) {
        this.normal = newNormal;
    }

    public Vec3 getVec1() {
        return this.vec1;
    }

    public Vec3 getVec2() {
        return this.vec2;
    }

    public Vec3 getVec3() {
        return this.vec3;
    }

    public Vec3 getColour() {
        return this.colour;
    }

    public Vec3 getNormal() {
        return this.normal;
    }
    
    public boolean isTextured() {
        return false;
    }
}
