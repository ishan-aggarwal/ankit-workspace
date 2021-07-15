package test;

public class InstaItem {

    protected String location;
    protected long timestamp;

    public InstaItem() {
        location = "Nowhere";
        timestamp = -1;
    }

    //second constructor
    public InstaItem(String location, long timestamp) {
        this.location = location;
        this.timestamp = timestamp;
    }

    //toString method
    @Override
    public String toString() {
        return "AT "+ this.location + " ON " +this.timestamp;
    }


}
