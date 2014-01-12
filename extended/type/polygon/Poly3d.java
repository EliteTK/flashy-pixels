package extended.type.polygon;

import extended.type.vector.Vec3d;

public class Poly3d {

    private Vec3d vec1 = new Vec3d(0, 0, 0);
    private Vec3d vec2 = new Vec3d(0, 0, 0);
    private Vec3d vec3 = new Vec3d(0, 0, 0);
    
    private Vec3d colour = new Vec3d(0, 0, 0);
    private Vec3d normal = new Vec3d(0, 0, 0);

    public Poly3d() {

    }

    public Poly3d(Vec3d vec1, Vec3d vec2, Vec3d vec3) {
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.vec3 = vec3;
        this.normal = Vec3d.normal(this.vec1, this.vec2, this.vec3);
    }

    public Poly3d(Vec3d vec1, Vec3d vec2, Vec3d vec3, Vec3d colour) {
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.vec3 = vec3;
        this.colour = colour;
        this.normal = Vec3d.normal(this.vec1, this.vec2, this.vec3);
    }

    public void setVec1(Vec3d newVec) {
        this.vec1 = newVec;
    }

    public void setVec2(Vec3d newVec) {
        this.vec2 = newVec;
    }

    public void setVec3(Vec3d newVec) {
        this.vec3 = newVec;
    }
    
    

    public void setColour(Vec3d newColour) {
        this.colour = newColour;
    }

    public void setNormal(Vec3d newNormal) {
        this.normal = newNormal;
    }
    

    public Vec3d getVec1() {
        return this.vec1;
    }

    public Vec3d getVec2() {
        return this.vec2;
    }

    public Vec3d getVec3() {
        return this.vec3;
    }

    public Vec3d getColour() {
        return this.colour;
    }
    
    

    public Vec3d getNormal() {
        return this.normal;
    }
    
    public boolean isTextured() {
        return false;
    }
}
