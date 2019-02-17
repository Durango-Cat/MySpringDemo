package main.atziji.java.test;

/**
 * 不同接口中有相同方法，同时调用报错情况
 *
 * Create by ZhuQiuPing
 * on 2017/8/12
 */
public class SimpleMethodInInterfaceTest implements I1{
    public void f() {

    }
//
//    public int f() {
//
//    }
}

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C1 {
    int f() {return 1;}
}