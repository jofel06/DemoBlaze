package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginDataUtil;
import utils.ScreenshotUtil;

public class ValidLoginTest extends BaseTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataUtil.class)
    public void testLoginWithValidCredentials(String username, String password){

        try {
            logger.info("Navigating to the Login page");
            loginPage.clickLoginLink();
            logger.info("Entering a valid username");
            loginPage.enterUsername(username);
            logger.info("Entering a valid password");
            loginPage.enterPassword(password);
            logger.info("Clicking the Login button");
            loginPage.clickLoginButton();
            logger.info("Login Successful");
        }

        catch (Exception e){
            ScreenshotUtil.captureScreenshot(driver, "testLoginWithValidCredentials_Error");
            logger.error("Login was not successful due to an error:", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
