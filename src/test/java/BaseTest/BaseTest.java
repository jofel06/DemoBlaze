package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    private String baseURl;

    @BeforeEach
    public void setup() throws IOException {
        //this will load the baseURL.properties file (you can find it in the test/java/resources directory)
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/baseURL.properties")) {
            properties.load(fis);
        }
        //this will get the base.url from the properties file
        baseURl = properties.getProperty("base.url");
    }

    @ParameterizedTest //used to run the test in different methods (browser)
    @ValueSource(strings = {"chrome", "edge"})
    public void baseDrivers(String browser){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        driver.get(baseURl);

        // Simulate test logic here
        System.out.println("Beginning Test on browser: " + browser);
        System.out.println("URL: " + baseURl);

        driver.quit();
    }
}
