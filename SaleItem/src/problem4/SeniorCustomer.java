package problem4;

import java.util.Calendar;

public class SeniorCustomer extends Customer{

    private static double DISCOUNT_RATE = 0.10;

    public double getDiscountRate() {
        double totalDiscount = super.getDiscountRate();
        Calendar instance = Calendar.getInstance();
        if(Calendar.TUESDAY == instance.get(Calendar.DAY_OF_WEEK)){
            totalDiscount += .10;
        }
        totalDiscount = Math.round(totalDiscount * 100.0) / 100.0;
        return totalDiscount;
    }

}
