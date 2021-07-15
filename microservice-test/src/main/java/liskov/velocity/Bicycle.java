package liskov.velocity;

public class Bicycle {
    // REQUIRES: 10 <= timeTaken <= 30
    // MODIFIES: this
    // EFFECTS: accelerates to 30 km/h in `timeTaken` seconds
    public void accelerateTo30(int timeTaken) {
        // stub
    }

    // EFFECTS: returns total calories burned in range [100, 200] for 15 minutes of activity
    public int getCaloriesBurned() {
        return 100; // stub
    }
}