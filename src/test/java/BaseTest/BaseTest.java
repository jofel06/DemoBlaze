package BaseTest;

import Page_Objects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected static String baseURl;
    public static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected LoginPage loginPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){

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
        loginPage = new LoginPage(driver);

        // Add the step to navigate to the base URL after initializing the driver
        logger.info("Navigating to base URL: " + baseURl);
        driver.get(baseURl);  // This will open the URL in the browser

    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            logger.info("Browser closed");

        }
    }
}
