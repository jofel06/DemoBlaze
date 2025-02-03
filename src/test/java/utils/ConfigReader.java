package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Logger logger = LogManager.getLogger(ConfigReader.class);

    private static final Properties properties = new Properties();
    private static final String Config_file_path = "C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Properties\\config.properties";

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

    //this gets the paths of the driver in the config.properties
    public static String getDriverPath(String browser) {

        String driver_path = null;

        if (browser.equalsIgnoreCase("chrome")) {
            driver_path = properties.getProperty("chrome.driver.path");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver_path = properties.getProperty("edge.driver.path");
        }

        if (driver_path == null) {
            logger.error("Driver path for {} is not provided.", browser);
            throw new IllegalStateException("Driver path for " + browser + " is not provided.");
        }
        return driver_path;
    }
}
