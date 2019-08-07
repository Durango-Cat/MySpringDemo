package main.atziji.java.test;

/**
 * 对继承的测试
 *
 * @author Zhuqiuping on 2019/7/22
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.showIt());

        ChildOne childOne = new ChildOne();
        System.out.println(childOne.showIt());
    }
}

class Parent {
    public String showIt() {
        return "this is show time!";
    }
}

class ChildOne extends Parent {
    @Override
    public String showIt() {
        System.out.println("xsxss");
        return super.showIt() + " but this is childOne show time!";
    }
}