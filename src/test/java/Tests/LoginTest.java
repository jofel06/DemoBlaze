package Tests;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.LoginDataUtil;

import java.time.Duration;


public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataUtil.class)
    public void test_Login(String username, String password){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            logger.info("Opening the website");
            driver.get(baseURl);
            logger.info("Navigating to the Login page");
            WebElement login_link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='navbarExample']//a[@id='login2']")));
            login_link.click();


            WebElement username_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
            WebElement password_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
            logger.info("Entering username");
            username_field.sendKeys(username);
            logger.info("Entering password");
            password_field.sendKeys(password);

            logger.info("Logging in");
            WebElement login_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']//button[@onclick='logIn()']")));
            login_button.click();
        }
        catch (Exception e){
            logger.error("Login failed due to an error: ", e);
        }
    }
}
