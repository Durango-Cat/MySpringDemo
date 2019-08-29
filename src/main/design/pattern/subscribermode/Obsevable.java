package main.design.pattern.subscribermode;

/**
 * 主题（被观察者）
 *
 * @author Zhuqiuping on 2019/7/18
 */
public interface Obsevable {
     void addObserver(Observer observer);
    Observer deleteObserver(Observer observer);

    void notifyObservers();
    void setChanged();

}
