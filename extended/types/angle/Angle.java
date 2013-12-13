package extended.types.angle;

public class Angle {

    private static Type defaultType = Type.RAD;

    private double angle = 0;
    private Type type = defaultType;

    public Angle() {

    }

    public Angle(double size) {
        this.angle = size;
    }

    public Angle(double size, Type type) {
        this.angle = size;
        this.type = type;
    }

    public double getAngle() {
        return angle;
    }

    public Type getType() {
        return type;
    }

    public static Type getDefaultType() {
        return defaultType;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(Angle angle) {
        this.angle = angle.angle;
        this.type = angle.type;
    }

    public static void setDefaultType(Type defaultType) {
        Angle.defaultType = defaultType;
    }

    public void convert(Type type) {
        if (this.type != type) {
            this.angle = this.angle / this.type.fullCircleValue() * type.fullCircleValue();
            this.type = type;
        }
    }

}
