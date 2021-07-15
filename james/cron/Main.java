package com.cron;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{

//      List<String> outPut = CronExpressionDescriptor.getDescription(("*/15 /2 1,15 * 6-7 /user/bin"));
        Map<String, String> description = CronExpressionDescriptor.getDescription("*/15 0 1,15 * 1-5 /user/bin/find");

        System.out.println(description);

    }
}
