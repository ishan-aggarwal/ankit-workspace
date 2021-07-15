//package com.example.read_excel_write_json;
//
//import java.util.Scanner;
//
//public class Test {
//
//    public static void main(String[] args) {
//
//        System.out.printf("%8.12s");
//
//        System.out.printf("%-12.8s");
//
//        System.out.printf("%-8.12s");
//
//        System.out.printf("%12.8s");
//    }
//} class FunkoPop {
//
//    private String name;
//    private int year;
//    private double price;
//
//    public FunkoPop() {
//        this.name = "Kline";
//        this.year = 2001;
//        this.price = 0.0;
//    }
//
//    public FunkoPop(String name, int year, double price) {
//        this.name = name;
//        this.year = year;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    //Write a main method (that would be inside a different class file)
//   // to declare two FunkoPop objects -- one with the default constructor,
//   // one with initialization values sent in
//    //    -- then use the getter methods to print all the data from one of the objects onto the screen
//
//
//    public static void main(String[] args) {
//        //with default constructor
//        FunkoPop funkoPop1 = new FunkoPop();
//        //with initialization
//        FunkoPop funkoPop2 = new FunkoPop("Kline", 2010, 20.0);
//
//        System.out.println("Name: "+funkoPop2.getName());
//        System.out.println("Year: "+funkoPop2.getYear());
//        System.out.println("Price: "+funkoPop2.getPrice());
//    }
//
//}
//
//public class TestApplication {
//    public static void main(String[] args) {
//        //with default constructor
//        FunkoPop funkoPop1 = new FunkoPop();
//        //with initialization
//        FunkoPop funkoPop2 = new FunkoPop("Kline", 2010, 20.0);
//
//        System.out.println("Name: " + funkoPop2.getName());
//        System.out.println("Year: " + funkoPop2.getYear());
//        System.out.println("Price: " + funkoPop2.getPrice());
//    }
//}