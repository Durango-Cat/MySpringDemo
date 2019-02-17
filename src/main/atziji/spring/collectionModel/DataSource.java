package main.atziji.spring.collectionModel;

import java.util.Properties;

/**
 * Created by zhuqiuping on 2017/1/19.
 */
public class DataSource {
    private Properties properties;

    public DataSource() {
    }

    public DataSource(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
