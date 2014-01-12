package extended.type.angle;

public enum Type {

    TURN(1),
    BRAD(256),
    DEG(360),
    RAD(2 * Math.PI),
    GRA(400);

    private final double fullCircleValue;

    Type(double fullCircleValue) {
        this.fullCircleValue = fullCircleValue;
    }

    public double fullCircleValue() {
        return fullCircleValue;
    }

}
