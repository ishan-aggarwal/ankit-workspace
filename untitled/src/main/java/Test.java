import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		SourceElementJsonSchemaDescription firstName = new SourceElementJsonSchemaDescription();
		firstName.setDescription("this is first name");
		firstName.setType("string");

		SourceElementJsonSchemaDescription lastName = new SourceElementJsonSchemaDescription();
		lastName.setType("string");

		SourceElementJsonSchemaDescription streetName = new SourceElementJsonSchemaDescription();
		streetName.setType("string");

		SourceElementJsonSchemaDescription age = new SourceElementJsonSchemaDescription();
		age.setType("integer");

		SourceElementJsonSchemaDescription streetname = new SourceElementJsonSchemaDescription();
		streetname.setDescription("strretname description");
		streetname.setType("string");

		Map<String, SourceElementJsonSchemaDescription> finalMap = new HashMap<>();
		finalMap.put("firstname", firstName);
		finalMap.put("lastname", lastName);
		finalMap.put("age", age);

		Map<String, SourceElementJsonSchemaDescription> streetMap = new HashMap<>();
		streetMap.put("streetname", streetname);

		SourceElementJsonSchemaDescription addresses = new SourceElementJsonSchemaDescription();
		addresses.setDescription("strretname description");
		addresses.setType("object");
		addresses.setProperties(streetMap);

		Map<String, SourceElementJsonSchemaDescription> addressesMap = new HashMap<>();
		addressesMap.put("address", addresses);

		SourceElementJsonSchemaDescription applicant = new SourceElementJsonSchemaDescription();
		applicant.setDescription("applicant description");
		applicant.setType("object");
		applicant.setProperties(addressesMap);

		finalMap.put("applicant", applicant);

		System.out.println(finalMap);

		SourceJsonSchema sourceJsonSchema = new SourceJsonSchema();
		sourceJsonSchema.setName("IG request");
		sourceJsonSchema.setDescription("Ig request description");
		sourceJsonSchema.setType("object");
		sourceJsonSchema.setProperties(finalMap);

		System.out.println(sourceJsonSchema);

		transformObject(sourceJsonSchema);

	}

	private static void transformObject(SourceJsonSchema sourceJsonSchema) {
		DestinationJsonSchema djs = new DestinationJsonSchema();

		djs.setTitle(sourceJsonSchema.getName());
		djs.setDescription(sourceJsonSchema.getDescription());
		djs.setType(sourceJsonSchema.getType());

		Map<String, DestinationJsonSchema> propertiesDest = new HashMap();
		Map<String, SourceElementJsonSchemaDescription> properties = sourceJsonSchema.getProperties();

		populatePropertyData(propertiesDest, properties);
		djs.setProperties(propertiesDest);
		System.out.println(propertiesDest);
	}

	private static void populatePropertyData(Map<String, DestinationJsonSchema> propertiesDest,
			Map<String, SourceElementJsonSchemaDescription> properties) {
		if (null != properties && !properties.isEmpty()) {
			for (String key : properties.keySet()) {
				SourceElementJsonSchemaDescription sourceElementJsonSchemaDescription = properties.get(key);
				DestinationJsonSchema innerdjs = new DestinationJsonSchema(sourceElementJsonSchemaDescription.getDescription(), sourceElementJsonSchemaDescription.getType());
				propertiesDest.put(key, innerdjs);
				
				if(sourceElementJsonSchemaDescription.getType().contentEquals("object")) {
					Map<String, DestinationJsonSchema> innerpropertiesDest = new HashMap();
					populatePropertyData(innerpropertiesDest, sourceElementJsonSchemaDescription.getProperties());
					innerdjs.setProperties(innerpropertiesDest);
				}
			}
		}
	}


}
