package BaseTest;

import Page_Objects.AddToCartPage;
import Page_Objects.LoginPage;
import Page_Objects.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;
import java.util.UUID;

public class BaseTest {
    protected WebDriver driver;
    protected static String baseURl;
    public static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected LoginPage loginPage;
    protected AddToCartPage addToCartPage;
    protected ProductsPage productsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, ITestResult result){

        String testName = result.getMethod().getMethodName();
        String threadName = browser.toUpperCase() + "-" + testName + "-" + Thread.currentThread().getId();

        ThreadContext.put("testName", testName); // Store test name in MDC
        ThreadContext.put("threadName", threadName); // Store custom thread name in MDC
        Thread.currentThread().setName(threadName); // Override actual thread name

        baseURl = ConfigReader.getBaseUrl(); //this loads the properties (base URL)
        //String driverPath = ConfigReader.getDriverPath(browser); // this gets the correct driver path from config.properties

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox"); //Disables Chrome's built-in security sandbox
            options.addArguments("--disable-dev-shm-usage"); //Tells Chrome not to use /dev/shm (shared memory) and use /tmp instead.
            // Set a unique temporary user data directory for each Chrome session, prevents the "user data directory already in use error".
            options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + UUID.randomUUID());
            driver = new ChromeDriver(options);
            logger.info("Starting test using Chrome browser for Test: " + testName);
            }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            // Set a unique temporary user data directory for each Chrome session, prevents the "user data directory already in use error".
            options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + UUID.randomUUID());
            driver = new EdgeDriver(options);
            logger.info("Starting Test using Edge browser for Test: " + testName);
            }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        loginPage = new LoginPage(driver);
        addToCartPage = new AddToCartPage(driver);
        productsPage = new ProductsPage(driver);
        logger.info("Navigating to base URL: " + baseURl);
        driver.get(baseURl);  // This will open the URL in the browser

    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            ThreadContext.remove("TestName");
            logger.info("Browser closed ");
        }
    }
}
