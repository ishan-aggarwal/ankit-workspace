package com.cron;

import java.text.ParseException;

/**
 * @author grhodes
 * @since 10 Dec 2012 10:58:21
 */
class ExpressionParser {

    private ExpressionParser() {
    }

    public static String[] parse(String expression) throws ParseException {
        String[] parsed = new String[] {"", "", "", "", "", ""};
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("expression_empty_exception");
        }
        String[] expressionParts = expression.split(" ");
        if (expressionParts.length != 6) {
            throw new ParseException(expression, 0);
        } else  {
           System.arraycopy(expressionParts, 0, parsed, 0, 6);
        }
        normaliseExpression(parsed);

        return parsed;
    }

    /**
     * @param expressionParts
     */
    private static void normaliseExpression(String[] expressionParts) {
        // Convert ? to * only for day of month and day of week
        expressionParts[2] = expressionParts[2].replace('?', '*');
        expressionParts[4] = expressionParts[4].replace('?', '*');

        // Convert 0/, 1/ to */
        expressionParts[0] = expressionParts[0].startsWith("0/") ? expressionParts[0].replace("0/", "*/") : expressionParts[0];
        expressionParts[1] = expressionParts[1].startsWith("0/") ? expressionParts[1].replace("0/", "*/") : expressionParts[1];
        expressionParts[2] = expressionParts[2].startsWith("1/") ? expressionParts[2].replace("1/", "*/") : expressionParts[2];
        expressionParts[3] = expressionParts[3].startsWith("1/") ? expressionParts[3].replace("1/", "*/") : expressionParts[3];
        expressionParts[4] = expressionParts[4].startsWith("1/") ? expressionParts[4].replace("1/", "*/") : expressionParts[4];

        // convert */1 to *
        for (int i = 0; i < expressionParts.length; i++) {
            if ("*/1".equals(expressionParts[i])) {
                expressionParts[i] = "*";
            }
        }
    }

}
