//package absencepayrollrequirements.exportcsv;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * Hello world!
// *
// */
//public class App {
//
//	public static List<InputModel> storeDataInList(Iterator<Row> rowIterator) {
//		InputModel inputModel = null;
//		List<InputModel> list = new ArrayList<InputModel>();
//		while (rowIterator.hasNext()) {
//			inputModel = new InputModel();
//			Row row = rowIterator.next();
//			Iterator<Cell> cellIterator = row.cellIterator();
//
//			inputModel.setCountry(cellIterator.next().getStringCellValue());
//			inputModel.setPayGroup(cellIterator.next().getStringCellValue());
//			if (!"ADP United States Apple Inc. Biweekly Hourly".equals(inputModel.getPayGroup())) {
//				continue;
//			}
//			inputModel.setAbsenceType(cellIterator.next().getStringCellValue());
//			inputModel.setWageType(cellIterator.next().getStringCellValue());
//			inputModel.setTimeOffVsLoa(cellIterator.next().getStringCellValue());
//			inputModel.setInfoType("IT"+ String.valueOf(cellIterator.next().getNumericCellValue()));
//			inputModel.setVersion(cellIterator.next().getStringCellValue());
//			inputModel.setTrigger(cellIterator.next().getStringCellValue());
//			inputModel.setWdUnits(cellIterator.next().getStringCellValue());
//			inputModel.setAdpUnits(cellIterator.next().getStringCellValue());
//			inputModel.setCompareWdToAdpUnits(cellIterator.next().getBooleanCellValue());
//			inputModel.setConversion(cellIterator.next().getStringCellValue());
//			inputModel.setConsolidationMethod(cellIterator.next().getStringCellValue());
//			inputModel.setReversalMethod(cellIterator.next().getStringCellValue());
//			inputModel.setClawback(cellIterator.next().getStringCellValue());
//			inputModel.setLookAheadOverwrite(cellIterator.next().getStringCellValue());
//			inputModel.setQuestionnaire(cellIterator.next().getStringCellValue());
//			inputModel.setComments(cellIterator.next().getStringCellValue());
//
//			list.add(inputModel);
//		}
//		System.out.println(list.size());
//		return list;
//	}
//
//	public static List<OutputModel> convertInputToOutputModel(List<InputModel> inputModels) {
//		List<OutputModel> outputModels = new ArrayList<OutputModel>();
//		List<com.example.read_excel_write_json.FieldModel> fieldModels = null;
//		OutputModel outputModel = null;
//		com.example.read_excel_write_json.FieldModel fieldModel = null;
//		for(InputModel inputModel:inputModels) {
//			outputModel = new OutputModel();
//			fieldModel = new com.example.read_excel_write_json.FieldModel();
//			fieldModels = new ArrayList<com.example.read_excel_write_json.FieldModel>();
//			outputModel.setCountry(inputModel.getCountry());
//			outputModel.setPayGroup(inputModel.getPayGroup());
//			outputModel.setObjectType(inputModel.getTimeOffVsLoa());
//			outputModel.setInfoType(inputModel.getInfoType());
//			outputModel.setInfoTypeVersion(inputModel.getVersion());
//			outputModel.setComments(inputModel.getComments());
//			fieldModel.setAbsenceType(inputModel.getAbsenceType());
//			fieldModel.setWageType(inputModel.getWageType());
//			fieldModel.setConversionMethod(inputModel.getConversion());
//			fieldModel.setConsolidationMethod(inputModel.getConsolidationMethod());
//			fieldModel.setReversalMethod(inputModel.getReversalMethod());
//			fieldModel.setClawback(inputModel.getClawback());
//			fieldModel.setQuestionnaire(inputModel.getQuestionnaire());
//			fieldModel.setComments(inputModel.getComments());
//			fieldModels.add(fieldModel);
//			outputModel.setFields(fieldModels);
//			System.out.println(outputModel.toString());
//			outputModels.add(outputModel);
//		}
//		return outputModels;
//	}
//
//	public static void main(String[] args) throws IOException {
//		InputModel inputModel = null;
//		FileInputStream file = new FileInputStream(
//				new File("src/main/resources/AbsencePayrollRequirementsUSAV(1.3).xlsx"));
//		// Create Workbook instance holding reference to .xlsx file
//
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//
//		// Get first/desired sheet from the workbook
//		XSSFSheet sheet = workbook.getSheet("Absence Framework Input");
//
//		Iterator<Row> rowIterator = sheet.iterator();
//		List<InputModel> inputDataList = storeDataInList(rowIterator);
//		List<OutputModel> outputDataList = convertInputToOutputModel(inputDataList);
//		System.out.println(outputDataList.size());
//
//		List<String> exportJsonList = new ArrayList<String>();
//		 ObjectMapper mapper = new ObjectMapper();
//		for(OutputModel model : outputDataList) {
//			ObjectNode objectNode = mapper.createObjectNode();
//			objectNode.put("attributes", mapper.valueToTree(model));
//			objectNode.put("id", outputDataList.indexOf(model) + 1);
//			objectNode.put("configType", "tableMapping");
//			objectNode.put("refId", "absencePayrollMapping");
//			objectNode.put("type", "absencePayrollMapping");
//			exportJsonList.add(objectNode.toPrettyString());
//		}
//
//		System.out.println(exportJsonList);
//		//Blank workbook
//        XSSFWorkbook workbook2 = new XSSFWorkbook();
//
//        //Create a blank sheet
//        XSSFSheet sheet2 = workbook2.createSheet("New Sheet");
//
//        int rownum = 0;
//
//        for(String json:exportJsonList) {
//        	int cellnum = 0;
//        	Row row = sheet2.createRow(rownum++);
//        	Cell cell = row.createCell(cellnum++);
//        	cell.setCellValue((String)json);
//
//        }
//        FileOutputStream out = new FileOutputStream(new File("src/main/resources/AbsencePayrollRequirementsUSAV(1.3)_N.xlsx"));
//        workbook2.write(out);
//        out.close();
//
//		file.close();
//	}
//}
