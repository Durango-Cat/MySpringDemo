package main.atziji.spring.createBeanByFactory;

/**
 * Created by zhuqiuping on 2017/1/18.
 */
public class Car {

    private String brand;
    private double price;

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
