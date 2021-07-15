package problem1;

import java.util.ArrayList;

public class Sale {

    private static double DISCOUNT_RATE = 0.05;

    private ArrayList<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public double getDiscountRate(){
        return DISCOUNT_RATE;
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

