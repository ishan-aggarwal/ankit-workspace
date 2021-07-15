package alex;

public class House {

    private int id;
    private double price;
    private String status;

    public House(int id, double price, String status) {
        this.id = id;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
