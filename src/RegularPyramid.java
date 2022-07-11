import static java.lang.Math.*;

public class RegularPyramid {
    private final int numberOfSides;
    private final double sideLength;
    private final double height;

    public RegularPyramid(int numberOfSides, double sideLength, double height) {
        this.numberOfSides = numberOfSides;
        this.sideLength = sideLength;
        this.height = height;
    }

    /**
     * returns the half of angle created by the triangles in base.
     */
    private double getAngleInDegree() {
        return 360.00 / (2.00 * numberOfSides);
    }

    private double getApothem() {
        return sideLength / (2.00 * tan(Math.toRadians(getAngleInDegree())));
    }

    /**
     * slant height = sqrt(h^2+r^2)
     */
    public double slantHeight() {
        return sqrt(pow(height, 2) + pow(getApothem(), 2));
    }

    /**
     * R = r * sec(pi/n)
     */
    public double baseCircumradius() {
        return getApothem() / cos(Math.toRadians(getAngleInDegree()));
    }

    /**
     * inRadius r = s / (2 * tan(360 / (2 * n));
     */

    public double basePerimeter() {
        return numberOfSides * sideLength;
    }

    /**
     * ba = n * area of a side
     */
    public double baseArea() {
        return numberOfSides * 0.5 * sideLength * getApothem();
    }

    /**
     * la = 0.5 * p * sh
     */
    public double lateralArea() {
        return 0.5 * basePerimeter() * slantHeight();
    }

    /**
     * sa = la + ba
     */
    public double totalSurfaceArea() {
        return lateralArea() + baseArea();
    }

    /**
     * v = 1/3 + ba * h
     */
    public double volume() {
        return (1.0 / 3.0) * baseArea() * height;
    }
}
