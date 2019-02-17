package main.atziji.java.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对<? extends E><? super E>在泛型中的使用
 *
 * Create by ZhuQiuPing
 * on 2017/10/22
 */
public class extendsAndSuperInGenericityTest {

    public static void main(String[] args) {
//        List<? super Fruit> fruitList = new ArrayList();
        List<Fruit> fruitList = new ArrayList();
        Fruit fruit = new Fruit();
        fruit.setName("I am Fruit");
        fruitList.add(fruit);
        Apple apple = new Apple();
        apple.setName("I am Apple");
        fruitList.add(apple);
        Banana banana = new Banana();
        banana.setName("I am Banana");
        fruitList.add(banana);

        fruitList.forEach(fruit1 -> {
            Fruit fruit2 = fruit1;
            System.out.println(fruit2);
        });

        //这样测试并没有达到真正的遍历和插入的目的

        //测试<? super T>，只能是Object类型接收
//        List<? super Fruit> superFruitList = fruitList;
////        fruitList.forEach(System.out:: println);
//        Object fruit1 = superFruitList.get(1);
//        System.out.println(fruit1);
//
//        //测试<? extends T>主要针对查询,查询的时候只能是Fruit类型接收
//        List<? extends Fruit> fruits = fruitList;
//        Fruit apple1 = fruits.get(1);
//        System.out.println(apple1);



    }
}


class Food {

    private String name;
    public String nameIs() {
        return "I am Food";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}

@NoArgsConstructor
class Fruit extends Food {
   private String name;

   public String nameIs() {
       return "I am Fruit";
   }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Banana extends Fruit {
    private String name;

    public String nameIs() {
        return "I am Banana";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Apple extends Fruit {
    private String name;

    public String nameIs() {
        return "I am Apple";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Meet extends Food {
    private String name;

    public String nameIs() {
        return "I am Meet";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "name='" + name + '\'' +
                '}';
    }
}
