package ch15.sec04.exam03;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

        for (Object key : properties.keySet()) {
            String value = properties.getProperty((String) key);
            System.out.println(key + "=" + value);
        }
    }
}
