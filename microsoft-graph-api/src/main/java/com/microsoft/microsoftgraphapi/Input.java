package com.microsoft.microsoftgraphapi;

public class Input {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Input{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
