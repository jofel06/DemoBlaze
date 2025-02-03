package BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.MDC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    public static String baseURl;
    public static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        ThreadContext.put("browser", browser); // this sets the browser name in Log4j2 (Thread Context)
        MDC.put("className", this.getClass().getSimpleName());  // Set test class name in MDC

        baseURl = ConfigReader.getBaseUrl(); //this loads the properties (base URL)
        String driverPath = ConfigReader.getDriverPath(browser); // this gets the correct driver path from config.properties

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            logger.info("Starting test using Chrome browser");
            }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", driverPath);
            driver = new EdgeDriver();
            logger.info("Starting Test using Edge browser");
            }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            logger.info("Browser closed");
            MDC.remove("className");  // Remove the class name from MDC after the test

        }
    }
}
