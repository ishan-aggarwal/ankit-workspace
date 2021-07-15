package assignment_old;

public class ContactInfo {

    public int id;
    public int distance;
    public int time;
    public boolean used;

    public ContactInfo(int id, int distance, int time) {
        this.id = id;
        this.distance = distance;
        this.time = time;

        //default value set as false
        this.used = false;
    }

    //returns true only if all fields are greater than 0
    public boolean isValid() {
        return id >= 0 && distance >= 0 && time >= 0;
    }

}
