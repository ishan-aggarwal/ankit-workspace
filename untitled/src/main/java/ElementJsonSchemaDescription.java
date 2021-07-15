import java.util.Map;

public class ElementJsonSchemaDescription {

    private String name;
    private String type;
    private Map<String, ElementJsonSchemaDescription> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, ElementJsonSchemaDescription> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, ElementJsonSchemaDescription> properties) {
        this.properties = properties;
    }
}
