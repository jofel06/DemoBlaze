package BaseTest;

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

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        // this loads the properties (base URL)
        baseURl = ConfigReader.getBaseUrl();

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Christian\\IdeaProjects\\DemoBlaze\\src\\test\\resources\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
