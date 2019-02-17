package main.java.java8model;

import main.java.model.Runnable;

/**
 * 针对java 1.8特性里面的lambda进行测试
 * Create by zhuqiuping
 * on 2017/3/24
 */
public class LambdaTest {
    public static void main(String[] args) {
        String foodName1;
        String foodName = "竹子";
        IEnimal enimal = () -> {
//            foodName1 = "山芋";
            return foodName;
        };

        System.out.println(enimal.eat());
//        Person person = new Person("尤小希", 22);
//        Student student = new Student("沈丽", 23);
//        IFunction IFunction = students -> {
//            if (students instanceof Student) {
//                String name = student.getName();
//                int age = student.getAge();
//                return new Person(name, age);
//            }
//         return person;
//        };
//        Object obj = (IFunction)students -> {
//            if (students instanceof Student) {
//                String name = student.getName();
//                int age = student.getAge();
//                return new Person(name, age);
//            }
//            return person;
//        };


//        Person person1 = (Person) IFunction.apply(student);
//        System.out.println(person1);
//
//        Runnable runnable = () -> {
//            System.out.println("我不知道Lambda怎么运行有返回参数的方式");
//        };
//
//        runnable.run();
    }
}
