package assignment_old;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class OutputModel {

//    private String country;
//    private
//    private FieldModel[] fields;

    public static void main(String[] args) {

        InputModel inputModel = new InputModel();
        inputModel.setAbsenceType("an");
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("attributes", mapper.valueToTree(inputModel));
        System.out.println(objectNode.toPrettyString());

    }

}


