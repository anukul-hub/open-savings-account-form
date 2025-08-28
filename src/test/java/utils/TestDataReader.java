package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static Properties properties;

    public static void loadTestData() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testdata.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testdata.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadTestData();
        }
        return properties.getProperty(key);
    }
}
