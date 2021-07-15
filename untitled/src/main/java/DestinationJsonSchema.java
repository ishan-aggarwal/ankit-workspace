import java.util.Map;

public class DestinationJsonSchema {

	private String title;
	private String description;
	private String type;
	private Map<String, DestinationJsonSchema> properties;
	
	

	public DestinationJsonSchema(String description, String type) {
		super();
		this.description = description;
		this.type = type;
	}

	public DestinationJsonSchema() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Map<String, DestinationJsonSchema> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, DestinationJsonSchema> properties) {
		this.properties = properties;
	}
}
