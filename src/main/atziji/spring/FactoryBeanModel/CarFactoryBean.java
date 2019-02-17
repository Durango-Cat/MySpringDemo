package main.atziji.spring.FactoryBeanModel;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zhuqiuping on 2017/1/22.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        return new Car("audi", 270000);
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
