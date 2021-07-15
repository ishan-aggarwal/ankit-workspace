package rseg102.streamofinvoices;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessInvoices {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    //a
    public static void printInvoices(List<Invoice> list) {
        list.stream().forEach(invoice -> {
            System.out.println("Part #: "+ invoice.getPartNumber()
                                + "\t" + "Description: "+ invoice.getPartDescription()
                                + "\t" + "Quantity: "+ invoice.getQuantity()
                                + "\t" + "Price: $ "+ invoice.getPricePerItem());
        });
    }

    //b
    public static List<Invoice> sortByPartDescription(Invoice[] invoices) {
        System.out.println("Invoices sorted by part description:");

        return Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .collect(Collectors.toList());
    }

    //c
    public static List<Invoice> sortByPricePerItem(Invoice[] invoices) {
        System.out.println("Invoices sorted by price:");

        return Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .collect(Collectors.toList());
    }

    //c
    private static void sortByQuantityMapToQuantityAndDescription(Invoice[] invoices) {
        System.out.println("Invoices mapped to description and quantity:");

        Arrays.stream(invoices)
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map(invoice -> "Description: "+ invoice.getPartDescription()+ "\t Quantity: " + invoice.getQuantity())
                .forEach(System.out::println);
    }

    //d
    private static void sortByInvoiceValue(Invoice[] invoices) {
        System.out.println("Invoices mapped to description and invoice amount:");

        Arrays.stream(invoices)
                .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPricePerItem()))
                .map(invoice -> "Description: "+ invoice.getPartDescription()+
                            "\t Quantity: " + String.format("%.2f", (invoice.getQuantity()* invoice.getPricePerItem())))
                .forEach(System.out::println);
    }

    //e
    private static void sortByInvoiceValueWithFilter(Invoice[] invoices) {
        System.out.println("Invoices mapped to description and invoice amount for invoices in the range 200-500:");

        Arrays.stream(invoices)
                .filter(invoice -> {
                    double invoiceValue = invoice.getQuantity()* invoice.getPricePerItem();
                    if(invoiceValue >= 200 && invoiceValue <= 500) return true;
                    else return false;
                })
                .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPricePerItem()))
                .map(invoice -> "Description: "+ invoice.getPartDescription()+
                        "\t Quantity: " + String.format("%.2f", (invoice.getQuantity()* invoice.getPricePerItem())))
                .forEach(System.out::println);
    }

    //f
    public static void filterInvoice(Invoice[] invoices) {
        System.out.println("Invoices in which the partDescription contains the word saw:");

         Arrays.stream(invoices)
                .filter(invoice -> invoice.getPartDescription().contains("saw"))
                .map(invoice ->
                        "Description: "+ invoice.getPartDescription()+
                        "\t Quantity: " + String.format("%.2f", (invoice.getQuantity()* invoice.getPricePerItem())))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        Invoice[] invoices = new Invoice[8];
 
        invoices[0] = new Invoice("83", "Electric sander", 7, 57.98);
        invoices[1] = new Invoice("24", "Power saw", 18, 99.99);
        invoices[2] = new Invoice("7", "Sledge hammer", 11, 21.50);
        invoices[3] = new Invoice("77", "Hammer", 76, 11.99);
        invoices[4] = new Invoice("39", "Lawn mower", 3, 79.50);
        invoices[5] = new Invoice("68", "Screwdriver", 106, 6.99);
        invoices[6] = new Invoice("56", "Jig saw", 21, 11);
        invoices[7] = new Invoice("3", "Wrench", 34, 7.50);

        //solution a
        List<Invoice> result1 = sortByPartDescription(invoices);
        printInvoices(result1);
        System.out.println();
        //solution b
        List<Invoice> result2 = sortByPricePerItem(invoices);
        printInvoices(result2);
        System.out.println();
        //solution c
        sortByQuantityMapToQuantityAndDescription(invoices);
        System.out.println();
        //d
        sortByInvoiceValue(invoices);
        System.out.println();
        //e
        sortByInvoiceValueWithFilter(invoices);

        System.out.println();
        //f
        filterInvoice(invoices);
    }


}
