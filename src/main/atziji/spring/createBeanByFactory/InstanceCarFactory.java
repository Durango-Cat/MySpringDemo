package main.atziji.spring.createBeanByFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuqiuping on 2017/1/22.
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("audi", new Car("Audi", 250000));
        cars.put("ford", new Car("Ford", 450000));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
