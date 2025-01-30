package BaseTest;

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
    public static String baseURl;

    public static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){

        baseURl = ConfigReader.getBaseUrl(); //this loads the properties (base URL)

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            logger.info("Starting test using Chrome browser");

        }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Drivers\\msedgedriver.exe");
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
        }
    }
}
