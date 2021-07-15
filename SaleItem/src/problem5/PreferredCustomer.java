package problem5;

public class PreferredCustomer extends Customer {

    private static double DISCOUNT_RATE = 0.15;

    public double getDiscountRate() {
        double totalDiscount = DISCOUNT_RATE + super.getDiscountRate();
        totalDiscount = Math.round(totalDiscount * 100.0) / 100.0;
        return totalDiscount;
    }

}
