package main.atziji.spring.model;

/**
 * Created by zhuqiuping on 2017/1/18.
 */
public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void getShow() {
        System.out.println("hello " + name);
    }
}
