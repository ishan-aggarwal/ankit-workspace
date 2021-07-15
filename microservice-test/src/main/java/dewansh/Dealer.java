package dewansh;

import org.apache.commons.math3.analysis.function.Add;

public abstract class Dealer {

    private String dealerName;
    private Address address;

    public Dealer(String dealerName, Address address) {
        this.dealerName = dealerName;
        this.address = address;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    abstract public double getConcession();

}
