package assignment_old;

import java.util.GregorianCalendar;

public class Test {
//
//    public static boolean isLeapYear(int year) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(year,1,1);
//        int days = cal.getMaximum(Calendar.DAY_OF_MONTH);
//        return (days ==29);
//    }
public static boolean isLeapYear(int year) {
    GregorianCalendar gc = new GregorianCalendar();
    return gc.isLeapYear(year);
}

    public static void main(String[] args)  {
        System.out.println(isLeapYear(2020));
    }
}
