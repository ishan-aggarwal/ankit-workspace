import java.util.Map;

public class SourceJsonSchema {

    private String name;
    private String description;
    private String type;
    private Map<String, SourceElementJsonSchemaDescription> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, SourceElementJsonSchemaDescription> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, SourceElementJsonSchemaDescription> properties) {
        this.properties = properties;
    }
}
