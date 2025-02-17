package BaseTest;

import Page_Objects.AddToCartPage;
import Page_Objects.LoginPage;
import Page_Objects.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected static String baseURl;
    public static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected LoginPage loginPage;
    protected AddToCartPage addToCartPage;
    public ProductsPage productsPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, ITestResult result){

        String testName = result.getMethod().getMethodName();
        String threadName = browser.toUpperCase() + "-" + testName + "-" + Thread.currentThread().getId();

        ThreadContext.put("testName", testName); // Store test name in MDC
        ThreadContext.put("threadName", threadName); // Store custom thread name in MDC
        Thread.currentThread().setName(threadName); // Override actual thread name

        baseURl = ConfigReader.getBaseUrl(); //this loads the properties (base URL)
        String driverPath = ConfigReader.getDriverPath(browser); // this gets the correct driver path from config.properties

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            logger.info("Starting test using Chrome browser for Test: " + testName);
            }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", driverPath);
            driver = new EdgeDriver();
            logger.info("Starting Test using Edge browser for Test: " + testName);
            }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();


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
