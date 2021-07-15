package com.example.read_excel_write_json;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputOutputHelper {
    public static List<InputModel> storeDataInList(Iterator<Row> rowIterator) {
        InputModel inputModel = null;
        List<InputModel> list = new ArrayList<InputModel>();
        while (rowIterator.hasNext()) {
            inputModel = new InputModel();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            inputModel.setCountry(cellIterator.next().getStringCellValue());
            inputModel.setPayGroup(cellIterator.next().getStringCellValue());
            if (!"ADP United States Apple Inc. Biweekly Hourly".equals(inputModel.getPayGroup())) {
                continue;
            }
            inputModel.setAbsenceType(cellIterator.next().getStringCellValue());
            inputModel.setWageType(cellIterator.next().getStringCellValue());
            inputModel.setTimeOffVsLoa(cellIterator.next().getStringCellValue());
            inputModel.setInfoType("IT"+Double.valueOf(cellIterator.next().getNumericCellValue()).intValue());
            inputModel.setVersion(cellIterator.next().getStringCellValue());
            inputModel.setTrigger(cellIterator.next().getStringCellValue());
            inputModel.setWdUnits(cellIterator.next().getStringCellValue());
            inputModel.setAdpUnits(cellIterator.next().getStringCellValue());
            inputModel.setCompareWdToAdpUnits(cellIterator.next().getBooleanCellValue());
            inputModel.setConversion(cellIterator.next().getStringCellValue());
            inputModel.setConsolidationMethod(cellIterator.next().getStringCellValue());
            inputModel.setReversalMethod(cellIterator.next().getStringCellValue());
            inputModel.setClawback(cellIterator.next().getStringCellValue());
            inputModel.setLookAheadOverwrite(cellIterator.next().getStringCellValue());
            inputModel.setQuestionnaire(cellIterator.next().getStringCellValue());
            inputModel.setComments(cellIterator.next().getStringCellValue());

            list.add(inputModel);
        }
        System.out.println(list.size());
        return list;
    }

    public static List<OutputModel> convertInputToOutputModel(List<InputModel> inputModels) {
        List<OutputModel> outputModels = new ArrayList<OutputModel>();
        List<FieldModel> fieldModels = null;
        OutputModel outputModel = null;
        FieldModel fieldModel = null;
        for(InputModel inputModel:inputModels) {
            outputModel = new OutputModel();
            fieldModel = new FieldModel();
            fieldModels = new ArrayList<FieldModel>();
            outputModel.setCountry(inputModel.getCountry());
            outputModel.setPayGroup(inputModel.getPayGroup());
            outputModel.setObjectType(inputModel.getTimeOffVsLoa());
            outputModel.setInfoType(inputModel.getInfoType());
            outputModel.setInfoTypeVersion(inputModel.getVersion());
            outputModel.setComments(inputModel.getComments());
            fieldModel.setAbsenceType(inputModel.getAbsenceType());
            fieldModel.setWageType(inputModel.getWageType());
            fieldModel.setConversionMethod(inputModel.getConversion());
            fieldModel.setConsolidationMethod(inputModel.getConsolidationMethod());
            fieldModel.setReversalMethod(inputModel.getReversalMethod());
            fieldModel.setClawback(inputModel.getClawback());
            fieldModel.setQuestionnaire(inputModel.getQuestionnaire());
            fieldModel.setComments(inputModel.getComments());
            fieldModels.add(fieldModel);
            outputModel.setFields(fieldModels);
            System.out.println(outputModel.toString());
            outputModels.add(outputModel);
        }
        return outputModels;
    }
}
