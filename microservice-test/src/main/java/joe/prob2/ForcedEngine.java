package joe.prob2;

public class ForcedEngine extends SimpleEngine{

    private int multiplier;

    public ForcedEngine(int horsepower) {
        super(horsepower);
        this.horsepower = horsepower;
        this.multiplier = 3;
    }

    @Override
    protected int totalForce() {
        int engineForce = super.totalForce();
        int forcedEngineForce= this.horsepower*this.multiplier;
        return engineForce+forcedEngineForce;
    }

    public static int engineHorsePower(int horsepower, int engineType) {
        SimpleEngine simpleEngine = null;
        if(engineType == 0) {
            simpleEngine = new SimpleEngine(horsepower);
        } else if(engineType == 1){
            simpleEngine = new ForcedEngine(horsepower);
        } else {
            throw new IllegalArgumentException("Expected engineType to be 0 or 1, but got "+engineType+" instead");
        }
        return simpleEngine.totalForce();
    }

    public static void main(String[] args) {
        System.out.println(engineHorsePower(50,1));
    }
}
