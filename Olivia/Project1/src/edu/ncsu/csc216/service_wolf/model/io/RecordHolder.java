package edu.ncsu.csc216.service_wolf.model.io;

import java.util.HashMap;
import java.util.Map;

public class RecordHolder {

    private Map<String, String> mapEvent;
    private StringBuilder request;
    private int counter;

    public Map<String, String> getMapEvent() {
        return mapEvent;
    }

    public void setMapEvent(Map<String, String> mapEvent) {
        this.mapEvent = mapEvent;
    }

    public StringBuilder getRequest() {
        return request;
    }

    public void setRequest(StringBuilder request) {
        this.request = request;
    }

    public void createNewMapEvent() {
        this.mapEvent = new HashMap<>();
    }

    public void createNewRequest() {
        this.request = new StringBuilder();
    }

    public void appendRequest(String line) {
        request.append(line).append("\n");
    }

    public void incrementCounter() {
        this.counter++;
    }

    public int getCounter() {
        return this.counter;
    }
}
