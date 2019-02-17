package main.atziji.spring.collectionModel;

import main.atziji.spring.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhuqiuping on 2017/1/19.
 */
public class NewPerson {
    private String name;
    private int age;
    private Map<String, Car> car;

    public NewPerson() {
    }

    public NewPerson(String name, int age, Map<String, Car> car) {
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

    public void setCar(Map<String, Car> car) {
        this.car = car;
    }

    public Map<String, Car> getCar() {
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
