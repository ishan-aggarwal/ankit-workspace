package assignment_old;

import java.util.ArrayList;

public class Server {

    public ArrayList<Integer> infectedIds;

    public Server() {
        infectedIds = new ArrayList<>();
    }

    //to add new infected id
    public boolean addInfectedIds(ArrayList<Integer> ids) {
        if(ids != null) {
            ids.stream().forEach(id-> infectedIds.add(id));
            return true;
        } else {
            return false;
        }
    }

    //to get all infected ids
    public ArrayList<Integer> getInfectedIds() {
        return new ArrayList<>(infectedIds);
    }


}
