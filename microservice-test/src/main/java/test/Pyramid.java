package test;

/**
 * Pyramid class - child class of Shape
 */
public class Pyramid extends Shape {

    private double base;
    private double height;

    /**
     * parameterized constructor
     * @param base
     * @param height
     */
    public Pyramid(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * method to calculate volume of pyramid
     * @return doube
     */
    @Override
    public double calcVolume() {
        return base * base * height / 3.0;
    }

    /**
     * method to calculate surface area of pyramid
     * @return double
     */
    @Override
    public double calcSurfaceArea() {
        return 4 * base * Math.sqrt((height * height) + (base * base / 4.0)) / 2.0;
    }

    /**
     * getter method for base
     * @return double
     */
    public double getBase() {
        return base;
    }

    /**
     * setter method for base
     * @param base
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * getter method for height
     * @return double
     */
    public double getHeight() {
        return height;
    }

    /**
     * setter method for height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
