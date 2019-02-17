package main.atziji.spring.collectionModel;

/**
 * Created by zhuqiuping on 2017/1/18.
 */
public class Car {

    private String brand;
    private String corp;
    private double price;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String corp, double price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, double price, int maxSpeed) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
