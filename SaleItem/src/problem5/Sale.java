package problem5;

import java.util.ArrayList;

public class Sale {

    private Customer customer;

    public Sale() {
        this.customer = new Customer();
    }

    public Sale(Customer customer)
    {
        this.customer = customer;
    }

    private ArrayList<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public double getDiscountRate(){
        return customer.getDiscountRate();
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

