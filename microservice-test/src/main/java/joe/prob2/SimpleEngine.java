package joe.prob2;

public class SimpleEngine {

    public int horsepower;
    public int multiplier;

    public SimpleEngine(int horsepower) {
        this.horsepower = horsepower;
        this.multiplier = 2;
    }

    protected int totalForce() {
        return this.horsepower*this.multiplier;
    }

}
