package com.cron;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @author grhodes
 * @since 10 Dec 2012 11:36:38
 */
public class CronExpressionDescriptor {

    private static final char[] specialCharacters = new char[] { '/', '-', ',', '*' };
    private static final char[] SpecialCharsMinusStar = new char[] { '/', '-', ',' };

    public CronExpressionDescriptor() {
    }

    public static Map<String, String> getDescription(String expression) throws ParseException {
        String[] expressionParts;
        String description = "";
        try {
            expressionParts = ExpressionParser.parse(expression);
            return getFullDescription(expressionParts);
        } catch (ParseException e) {
                System.out.println("Exception parsing expression." + e);
                throw e;
            }
      //  return description;
    }


    /**
     * @param expressionParts
     * @return
     */
    private static Map<String, String> getFullDescription(String[] expressionParts) {
        String description = "";
        List<String> outPut = new LinkedList<>();
        Map<String, String> outputMap = new LinkedHashMap<>();

        for (int i=0; i< expressionParts.length -1 ; i++){
            description = getSegmentDescription(expressionParts[i], i);
            outPut.add(description);
        }
        outPut.add(expressionParts[expressionParts.length -1]);

        outputMap.put("minute", outPut.get(0));
        outputMap.put("hour", outPut.get(1));
        outputMap.put("day of month", outPut.get(2));
        outputMap.put("month", outPut.get(3));
        outputMap.put("day of week", outPut.get(4));
        outputMap.put("command", outPut.get(5));

        return outputMap;
    }


    private static String getSegmentDescription(String expression, int index) {
        StringBuilder description = new StringBuilder();
        int end =0;
        switch (index){
            case 0 : end = 60; break;
            case 1 : end = 24; break;
            case 2: end = 31; break;
            case 3: end = 12; break;
            case 4: end = 7; break;
        }
        if (expression.isEmpty()) {
            description.append("");
        } else if ("*".equals(expression)) {
                for(int j=1; j<=end ; j ++ ){
                    description.append(j);
                    description.append(" ");
                }

        } else if (!containsAny(expression, SpecialCharsMinusStar)) {
            description.append(expression);
        } else if (expression.contains("/")) {
            String[] segments = expression.split("/");
            int times = end /Integer.valueOf(segments[1]) ;
            for(int k = 0; k < times; k++){
                description.append(k*Integer.valueOf(segments[1]));
                description.append(" ");
            }
        } else if (expression.contains(",")) {
            String[] segments = expression.split(",");
            StringBuilder descriptionContent = new StringBuilder();
            for ( int i = 0; i < segments.length; i++) {
                if ((i > 0) && (segments.length > 2)) {
                    if (i < (segments.length - 1)) {
                        descriptionContent.append(", ");
                    }
                }
                description.append(segments[i]);
                description.append(" ");
            }
        } else if (expression.contains("-")) {
            String[] segments = expression.split("-");
            int start = Integer.valueOf(segments[0]);
            int endS = Integer.valueOf(segments[1]);

            if(endS > end ) endS = end;
            if(start > endS) start = 0;

            for(int i = start ; i <= endS ; i++){
                description.append(i);
                description.append(" ");
            }
        }
        return description.toString();
    }


    private static boolean containsAny(String str, char[] searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

}
