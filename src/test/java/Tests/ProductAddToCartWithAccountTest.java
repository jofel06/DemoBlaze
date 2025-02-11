package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginDataUtil;

public class ProductAddToCartWithAccountTest extends BaseTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataUtil.class)
    public void testAddToCartWithValidAccount(String username, String password){

        try {
            logger.info("Clicking the Login Page");
            loginPage.clickLoginLink();
            logger.info("Entering a valid username");
            loginPage.enterUsername(username);
            logger.info("Entering a valid password");
            loginPage.enterPassword(password);
            logger.info("Logging in");
            loginPage.clickLoginButton();
            logger.info("Login was Successful");
            logger.info("Navigating to the Monitors Category");
            productsPage.clickMonitorsCategory();
            logger.info("Selecting a Monitor Product");
            productsPage.clickProduct("Apple monitor 24");
            logger.info("Adding the Item to cart");
            productsPage.clickProductAddToCartBtnAndAcceptAlert();
            logger.info("Item successfully added to the cart");
            logger.info("Going back to Home Page");
            productsPage.clickHomePageLink();
            logger.info("Navigating to the Laptops Category");
            productsPage.clickLaptopsCategory();
            logger.info("Selecting a Laptop Product");
            productsPage.clickProduct("MacBook air");
            logger.info("Adding the Item to Cart");
            productsPage.clickProductAddToCartBtnAndAcceptAlert();
            logger.info("Item successfully added to the cart");
            logger.info("Navigating to the cart page");
            addToCartPage.clickCartLink();
        }
        catch (Exception e){
            logger.error("Add to Cart test was not successful due to an error:", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
