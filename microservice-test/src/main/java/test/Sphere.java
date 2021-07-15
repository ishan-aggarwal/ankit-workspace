package test;

/**
 * Sphere class - child class of shape
 */
public class Sphere extends Shape {

    private double radius;
    public static final double PI = 3.14159;

    /**
     * parameterized constructor
     * @param radius
     */
    public Sphere(double radius) {
        this.radius = radius;
    }

    /**
     * method to calculate volume of sphere
     * @return doube
     */
    @Override
    public double calcVolume() {
        return (4/3.0) * PI * radius * radius * radius;
    }

    /**
     * method to calculate surface area of sphere
     * @return double
     */
    @Override
    public double calcSurfaceArea() {
        return 4.0 * PI * radius * radius;
    }

    /**
     * getter method for radius
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * setter method for radius
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * getter method for constant PI
     * @return double
     */
    public static double getPI() {
        return PI;
    }
}
