//package saleitem;
//
////import java.util.Enumeration;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
////import java.util.Vector;
////Sale class
//public class Sale {
//    private static double DISCOUNT_RATE = 0.05;
//    //private Vector itemList = new Vector();
//    List<String> itemList = new ArrayList<>();
//
//    //addItem method
//    public void addItem(String item) {
////Constructor method to create an object of the Scanner class -userIn
//        Scanner userIn = new Scanner(System.in);
//        System.out.println("How many items do you want to add?");
////The number of times the items will be added to itemList vector
//        int numLines = userIn.nextInt();
////Instantiating the input string
//        String s;
//        for (int i = 0; i <= numLines; i++) {
//            s = userIn.nextLine();
//            System.out.println("Add items");
////Calling the addItem method
////itemList.addElement(ite);
////Add new items to the itemList
//            itemList.add(s);
////itemList.
//        }
////closing the Scanner method
//        userIn.close();
//    }
//
//    //getDiscountRate method
//    public double getDiscountRate() {
//        return DISCOUNT_RATE;
//    }
//
//    //getDiscount method
//    public double getDiscount() {
//        return getSubTotal() * getDiscountRate();
//    }
//
//    //getSubTotal method
//    public double getSubTotal() {
//        double subTotal = 0.0;
////Enumeration items = itemList.elements();
////Initialize to start from 1 since we are checking for the number of items not index
//        for (int i = 1; i < itemList.size(); i++) {
//            subTotal++;
//        }
///**
// while (items.hasMoreElements()) {
// Item theNextItem = (Item)nextElement();
// subTotal += theNextItem.getItemTotal();
// }
// */
//        return subTotal;
//    }
////nextElement method
///**
// private Item nextElement() {
// return null;
// }
// *
// * The nextElement method is cancelled
// */
//return
//
//    getSubTotal() -
//
//    getDiscount();
//}
//}
//
