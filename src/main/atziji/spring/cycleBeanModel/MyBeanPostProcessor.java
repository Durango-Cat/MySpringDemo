package main.atziji.spring.cycleBeanModel;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by zhuqiuping on 2017/1/22.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("before initialization ... " + bean + " , " + beanName);

//        if("car".equals(beanName)) {
//            //.....
//        }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("after initialization ... " + bean + " , " + beanName);
//        Car car = new Car();
//        car.setName("xxxxx");
                return bean;
    }
}
