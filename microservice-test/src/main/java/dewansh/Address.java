package dewansh;

public class Address {

    private String shopNo;
    private String city;
    private String state;
    private String postCode;

    public Address(String shopNo, String city, String state, String postCode) {
        this.shopNo = shopNo;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
