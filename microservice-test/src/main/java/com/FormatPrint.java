package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FormatPrint {

    public static void main(String[] args) {
        List<String> list =
                List.of("ArrayBasedList","1003333","23433","22334","4100333356","63373","1001003333","2341003333","2234","456",
                        "110033332","2310033333","10033333");
        List<String> list2 =
                List.of("LinkedList","100","234","2234","456","6373","100","234","2234","456",
                        "12","233","3");
        List<List<String>> listOfList = new ArrayList<>();
        listOfList.add(prepareHeaderRow1());
        listOfList.add(prepareHeaderRow2());
        listOfList.add(prepareHeaderRow3());
        listOfList.add(list);
        listOfList.add(list2);
        System.out.println("test");
        System.out.println(formatAsTable(listOfList));
    }

    public static List<String> prepareHeaderRow1() {
        List<String> list = new ArrayList<>();

        list.add("");
        for(int i=1; i<=10; i++) {
            list.add("Run "+i);
        }
        list.add("Average");
        list.add("Memory Usage");
        return list;
     }

    public static List<String> prepareHeaderRow2() {
        List<String> list = new ArrayList<>();

        list.add("");
        for(int i=1; i<=10; i++) {
            list.add("nano sec");
        }
        list.add("nano sec");
        list.add("Mega Bytes");
        return list;
    }
    public static List<String> prepareHeaderRow3() {
        List<String> list = new ArrayList<>();

        list.add("");
        for(int i=1; i<=10; i++) {
            list.add("--------");
        }
        list.add("--------");
        list.add("--------");
        return list;
    }

    public static String formatAsTable(List<List<String>> rows)
    {
        int[] maxLengths = new int[rows.get(0).size()];
        for (List<String> row : rows)
        {
            for (int i = 0; i < row.size(); i++)
            {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths)
        {
            formatBuilder.append("%-").append(maxLength + 2).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows)
        {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }
}
