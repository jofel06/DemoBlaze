package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Logger logger = LogManager.getLogger(ConfigReader.class);

    private static final Properties properties = new Properties();
    private static final String Config_file_path = "src/test/resources/Properties/config.properties";

    static {
        try (FileInputStream inputStream = new FileInputStream(Config_file_path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("An error occurred while loading the configuration", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    /*this gets the paths of the driver in the config.properties
    public static String getDriverPath(String browser) {

        String os = System.getProperty("os.name").toLowerCase();

        if (browser.equalsIgnoreCase("chrome")) {
            if (os.contains("win")){
                return properties.getProperty("chrome.driver.win.path");
            } else if (os.contains("nux")){
                return properties.getProperty("chrome.driver.linux.path");
            }

        } else if (browser.equalsIgnoreCase("edge")) {
            if (os.contains("win")){
                return properties.getProperty("edge.driver.win.path");
            } else if (os.contains("nux")) {
                return properties.getProperty("edge.driver.linux.path");
            }

        }
        throw new RuntimeException("Driver not configured for the operating system.");
    }*/
}
