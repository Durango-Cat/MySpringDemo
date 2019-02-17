package main.atziji.spring.createBeanByFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *  b嘻嘻嘻
 */
public class StaticCarFactory {
    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("Audi", new Car("audi", 300000));
        cars.put("Ford", new Car("ford", 400000));
    }

    public static Car getCars(String brand) {
        return cars.get(brand);
    }
}
