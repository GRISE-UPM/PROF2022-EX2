package es.upm.grise.prof2022.ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileAccessor {

    Properties properties;

    public Properties load(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("resources/" + path));
        this.properties = properties;
        return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }


}
