package main.java.TestBooleanOfGetter;

/**
 * Create by zhuqiuping
 * on 2017/5/23
 */
public class Person {
    private String name;
    private boolean isMan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }
}
