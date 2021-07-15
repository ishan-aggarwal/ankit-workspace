package com.example.read_excel_write_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(
				new File("src/main/resources/AbsencePayrollRequirementsUSAV(1.3).xlsx"));
		// Create Workbook instance holding reference to .xlsx file
		FileOutputStream fileOutputStream = new FileOutputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("Absence Framework Input");

		Iterator<Row> rowIterator = sheet.iterator();
		List<InputModel> inputDataList = InputOutputHelper.storeDataInList(rowIterator);
		List<OutputModel> outputDataList = InputOutputHelper.convertInputToOutputModel(inputDataList);
		System.out.println(outputDataList.size());

		List<String> exportJsonList = new ArrayList<String>();
		 ObjectMapper mapper = new ObjectMapper();
		for(OutputModel model : outputDataList) {
			ObjectNode objectNode = mapper.createObjectNode();
			objectNode.put("attributes", mapper.valueToTree(model));
			objectNode.put("id", outputDataList.indexOf(model) + 1);
			objectNode.put("configType", "tableMapping");
			objectNode.put("refId", "absencePayrollMapping");
			objectNode.put("type", "absencePayrollMapping");
			exportJsonList.add(objectNode.toPrettyString());
		}

		System.out.println(exportJsonList);
		//Blank workbook
        XSSFWorkbook workbook2 = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet2 = workbook2.createSheet("New Sheet");

        int rownum = 0;
		Row headerRow = sheet2.createRow(rownum++);
		headerRow.createCell(0);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Header");

        for(String json:exportJsonList) {
        	int cellnum = 0;
        	Row row = sheet2.createRow(rownum++);
        	Cell cell = row.createCell(cellnum++);
        	cell.setCellValue(json);
        }
        FileOutputStream out = new FileOutputStream(new File("src/main/resources/AbsencePayrollRequirementsUSAV(1.3)_N.xlsx"));
        workbook2.write(out);
        out.close();

		file.close();
	}
}
