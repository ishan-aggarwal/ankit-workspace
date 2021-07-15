package abhimanyu;

import io.cucumber.java.ca.Cal;

import java.util.ArrayList;
import java.util.Calendar;

public class Testing3 {

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getTime());
        Calendar instance = Calendar.getInstance();
        instance.set(2021, Calendar.APRIL, 27);
        System.out.println(Calendar.TUESDAY == instance.get(Calendar.DAY_OF_WEEK));
    }
}
