package project5;

import java.util.Map;

public class RestStop implements Comparable<RestStop> {

    String LABEL;
    Map<String, Integer> suppliesMap;
    Map<String, Integer> obstaclesMap;

    public Map<String, Integer> getObstaclesMap() {
        return obstaclesMap;
    }

    public RestStop(String LABEL, Map<String, Integer> suppliesMap, Map<String, Integer> obstaclesMap) {
        this.LABEL = LABEL;
        this.suppliesMap = suppliesMap;
        this.obstaclesMap = obstaclesMap;
    }


    @Override
    public String toString() {
        return "RestStop{" +
                "LABEL=" + LABEL +
                '}';
    }

    public String getLABEL() {
        return LABEL;
    }

    public Map<String, Integer> getSuppliesMap() {
        return suppliesMap;
    }

    @Override
    public int compareTo(RestStop o) {
        return this.LABEL.compareTo ( o.LABEL );
    }
}
