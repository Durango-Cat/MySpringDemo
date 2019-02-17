package main.atziji.java.test;

/**
 * 构造器在代码中执行的顺序
 *
 * Create by ZhuQiuPing
 * on 2017/8/7
 */
public class Sandwich extends PortableLunch {
    private static Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
//    private Sandwich s = new Sandwich();  //如果这行一写就会无限循环下去，最后会报这行初始化出错
    public Sandwich() {
        System.out.println("Sandwich()");
        System.out.println();
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal {
    Meal() {
        System.out.println("Meal()");
        System.out.println();
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}