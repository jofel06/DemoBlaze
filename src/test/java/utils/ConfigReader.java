package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Properties\\baseURL.properties")) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file for the baseURL.");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
}
