package main.design.pattern.subscribermode;

import java.util.Observable;
import java.util.Observer;

/**
 * 代理模式测试(主题-观察者，即一对多的模式）
 * 当主题变动的时候，会发送通知告诉关联的观察者；可以在主题中增加或者删除观察者。
 *
 * Create by ZhuQiuPing
 * on 2017/11/5
 */
public class ObserverProxyTest {

    public static void main(String[] args) {
        //这次的测试使用pull("拉")的方式，观察者将数据从主题中拉出来；
        MyObservable myObservable = new MyObservable();

        MyObserver myObserver = new MyObserver();
        myObservable.addObserver(myObserver);

        //OtherObserver otherObserver = new OtherObserver();
        //myObservable.addObserver(otherObserver);

//        OtherObserver otherObserver2 = new OtherObserver();
//        myObservable.addObserver(otherObserver2);
//
//        OtherObserver otherObserver3 = new OtherObserver();
//        myObservable.addObserver(otherObserver3);

        //myObservable.setData("第一章的第六题");
        //myObserver.update(myObservable, null);

          //myObservable.arrangeTheHomework("第二章的三四五题");
//        myObservable.notifyObservers();
    }
}

/**
 * 会创建两个类，一个是Observer（观察者）, 继承Observable类的主题, 这种方式就是pull方式
 */
class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        MyObservable myObservable = (MyObservable)o;
        System.out.println("对应的任务是：" + myObservable.getData());
    }
}

/**
 * 另一个观察者，用push方式来获取主题布置的内容
 */
class OtherObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        //同一都改成实现了Observable的主体类
        MyObservable myObservable = (MyObservable)o;
        myObservable.arrangeTheHomework(arg);
        System.out.println("今天另一个观察者的任务二是：" + arg);
    }
}

class MyObservable extends Observable {
    private Object data;
    //这是pull的操作方式，观察者通过get方法来获取到需要的内容
    public Object getData() {
        System.out.println("今天的任务是：" + data.toString());
        return data;
    }
    //这是pull的操作方式
    public void setData(Object data) {
        this.data = data;
        setChanged();
        notifyObservers();
    }

    /**
     * 这里要有一个方法是向主题中修改的内容填充到要给观察者的内容 push
     */
    public void arrangeTheHomework(Object args) {
        setChanged();
        System.out.println("今天的任务二是：" + args);
        notifyObservers(args);
    }
}
