package problem3;

import java.util.ArrayList;
import java.util.Calendar;

public class Sale {

    private static double DISCOUNT_RATE = 0.05;
    private CustomerType customerType;

    public Sale(CustomerType customerType) {
        this.customerType = customerType;
    }

    private ArrayList<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public double getDiscountRate(){

        double totalDiscount = DISCOUNT_RATE;

        switch (customerType) {
            case SENIOR:
                Calendar instance = Calendar.getInstance();
                if(Calendar.TUESDAY == instance.get(Calendar.DAY_OF_WEEK)){
                    totalDiscount += .10;
                }
                break;
            case PREFERRED:
                totalDiscount += .15;
                break;
        }
        return totalDiscount;
    }

    public double getDiscount(){
        return getSubTotal()*getDiscountRate();
    }

    public double getSubTotal() {
        double subTotal = 0.0;
        for (Item item: itemList) {
            subTotal += item.getItemTotal();
        }
        return subTotal;
    }

    public double getDiscountedSubTotal() {
        return getSubTotal() - getDiscount();
    }

}

