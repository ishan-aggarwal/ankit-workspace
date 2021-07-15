package liskov.velocity;

public class ElectricBicycle extends Bicycle {
    // REQUIRES: 10 <= timeTaken <= 40
    // MODIFIES: this
    // EFFECTS: accelerates to 30 km/h in `timeTaken` seconds
    @Override
    public void accelerateTo30(int timeTaken) {
        // stub
    }

    // EFFECTS: returns total calories burned in range [80, 200] for 15 minutes of activity
    @Override
    public int getCaloriesBurned() {
        return 80; // stub
    }
}