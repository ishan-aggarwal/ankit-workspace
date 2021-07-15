package diksha;

public class Car {

    private Integer carId;
    private Integer price;
    private String model;
    private String color;

    public Car(Integer carId, Integer price, String model, String color) {
        this.carId = carId;
        this.price = price;
        this.model = model;
        this.color = color;
    }

    public Integer getCarId() {
        return carId;
    }

    public Integer getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getCarInfo() {
        return "Car{" +
                "carId=" + carId +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
