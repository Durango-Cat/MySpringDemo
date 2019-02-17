package main.atziji.spring.cycleBeanModel;

/**
 * Created by zhuqiuping on 2017/1/22.
 */
public class Car {
    private String name;

    public Car() {
        System.out.println("bean constructor....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destory() {
        System.out.println("destory...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
