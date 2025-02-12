package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // this Capture the screenshot as a file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // this defines the destination for the screenshot (make sure that the screenshots folder is already created)
        String destination = "screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(srcFile, new File(destination));
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: {}", destination, e);
        }
    }
}
