package main.atziji.spring.test;

import main.atziji.spring.FactoryBeanModel.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhuqiuping on 2017/1/18.
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Person person = (Person)atx.getBean("person1");
//        System.out.println(person);
//
//        Car car = (Car)atx.getBean("car");
//        System.out.println(car);

//        HelloWorld helloWorld = (HelloWorld)atx.getBean("helloworld");
//        helloWorld.getShow();

//        NewPerson person = (NewPerson) atx.getBean("newperson");
//        System.out.println(person);

//         DataSource dataSource = (DataSource)atx.getBean("dataSource");
//         System.out.println(dataSource);

//        Person person = (Person)atx.getBean("person");
//        System.out.println(person);

//        Address address = (Address) atx.getBean("address");
//        System.out.println(address);
//          Address address2 = (Address)atx.getBean("address2");
//          System.out.println(address2);
        //bean的生命周期演示开始
//        ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Car car = (Car) cpxac.getBean("car");
//        System.out.println(car);
//        cpxac.destroy();
        //演示结束
//
//        Person person = (Person)atx.getBean("person");
//        System.out.println(person);

        //静态工厂方法创建bean
        Car car = (Car)atx.getBean("car");
        System.out.println(car);

    }
}
