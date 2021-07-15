package com.cron;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{

        Map<String, String> description = CronExpressionDescriptor.getDescription("*/15 0 1,15 * 1-5 /user/bin/find");
        description.forEach((key,value)-> {
            System.out.printf("%-15s%s%n", key, value);
        } );

    }
}
