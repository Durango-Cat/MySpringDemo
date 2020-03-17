package main.bytecode;

/**
 * 稍微复杂一点的代码，主要看发编译之后的信息是否自己能琢磨透
 *
 * @author zhuqp on 2020/3/9
 */
public class MyTest2 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }
    //如果把这个方法的访问类型 改成private 生成的反编译里面 看不到这个方法了，如果想要看反编译里面包含private的，需要在命令行加一个-p
    //比如：javap -verbose -p main/bytecode/MyTest2.class
    //再加上synchronized关键字，反编译一下看看
//    private void setX(int x) {
    private synchronized void setX(int x) {
//    public void setX(int x) {
        this.x = x;
    }

}
