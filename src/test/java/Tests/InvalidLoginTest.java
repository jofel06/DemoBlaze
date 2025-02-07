package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginDataUtil;

public class InvalidLoginTest extends BaseTest {

    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataUtil.class)
    public void loginWithInvalidCredentials(String username, String password){

        try{
            logger.info("Navigating to the Login page");
            loginPage.clickLoginLink();
            logger.info("Entering an invalid username");
            loginPage.enterUsername(username);
            logger.info("Entering an invalid password");
            loginPage.enterPassword(password);
            logger.info("Clicking the Login button");
            loginPage.clickLoginButtonAndAcceptAlert();
            logger.info("Login Failed, please enter a valid username or password");
        }
        catch (Exception e){
            logger.error("Login was not successful due to an error:", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
