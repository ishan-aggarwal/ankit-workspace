package dewansh;

import org.apache.commons.math3.analysis.function.Add;

import java.util.List;

public class TwoWheeler extends Dealer {

    private String modelName;
    private int modelNo;
    private double price;
    private List<String> addOns;

    public TwoWheeler(String dealerName, Address address,
                      String modelName, int modelNo,
                      double price, List<String> addOns) {
        super(dealerName, address);
        this.modelName = modelName;
        this.modelNo = modelNo;
        this.price = price;
        this.addOns = addOns;
    }

    public double getConcession() {
        return price*.05;
    }

    public void printEstimate() {
        double totalPrice = price - getConcession();
        System.out.println("Total Price (base price - concession) - "+ totalPrice );
        System.out.println("Add ons - "+ String.join(", ", addOns));
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }

    public static void main(String[] args) {
        List<String> addons = List.of("Head Gaurd","Fog Light","Foot Mats");
        Address address = new Address("23 Krishna Nagar", "Delhi", "Delhi", "110051");
        TwoWheeler twoWheeler = new TwoWheeler("Honda", address,
                "Activa", 12, 50000, addons);

        twoWheeler.printEstimate();
    }
}
