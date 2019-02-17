package main.atziji.java.test;


/**
 * Create by ZhuQiuPing
 * on 2017/8/6
 */
public class FieldAccess {

    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup's field:" + sup.field + ", getField():" + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub's field:" + sub.field + ", getField():" + sub.getField()
                + ", getSuperField():" + sub.getSuperField());
    }
}

class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}
