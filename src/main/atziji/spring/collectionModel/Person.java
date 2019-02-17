package main.atziji.spring.collectionModel;

import main.atziji.spring.collectionModel.Car;

import java.util.List;

/**
 * Created by zhuqiuping on 2017/1/18.
 */
public class Person {
    private String name;
    private int age;
    private List<Car> car;

    public Person() {
    }

    public Person(String name, int age, List<Car> car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<Car> getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
