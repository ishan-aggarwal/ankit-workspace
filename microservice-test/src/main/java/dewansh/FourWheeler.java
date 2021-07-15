package dewansh;

import java.util.List;

public class FourWheeler extends Dealer{

    private String modelName;
    private int modelNo;
    private double price;
    private List<String> addOns;
    private String fuelType;

    public FourWheeler(String dealerName, Address address,
                       String modelName, int modelNo,
                       double price, List<String> addOns, String fuelType) {
        super(dealerName, address);
        this.modelName = modelName;
        this.modelNo = modelNo;
        this.price = price;
        this.addOns = addOns;
        this.fuelType = fuelType;
    }

    public double getConcession() {
        return price*.10;
    }

    public void printEstimate() {
        double totalPrice = price - getConcession();
        System.out.println("Total Price (base price - concession) - "+ totalPrice );
        System.out.println("Add ons - "+ String.join(", ", addOns));
    }

    public static void main(String[] args) {
        List<String> addons = List.of("Music System","Fog Light","Seat cover");
        Address address = new Address("23 Krishna Nagar", "Delhi", "Delhi", "110051");
        FourWheeler fourWheeler = new FourWheeler("Honda", address,
                "Honda City", 45, 1500000, addons, "Petrol");

        fourWheeler.printEstimate();
    }

}
