package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

public class CartPageWithoutAccountTest extends BaseTest {

    @Test
    public void testCartPageWithoutAccount(){

        try {
            logger.info("Navigating to Cart Page");
            addToCartPage.clickCartLink();
            logger.info("Placing the Order");
            addToCartPage.clickCartPlaceOrderBtn();
            logger.info("Entering the Name");
            addToCartPage.enterName("John");
            logger.info("Entering the Country");
            addToCartPage.enterCountry("Japan");
            logger.info("Entering the City");
            addToCartPage.enterCity("Tokyo");
            logger.info("Entering the Credit Card Information");
            addToCartPage.enterCreditCard("01111-2222-3333");
            logger.info("Entering the Month");
            addToCartPage.enterMonth("January");
            logger.info("Entering the Year");
            addToCartPage.enterYear("2050");
            logger.info("Clicking the Purchase Button");
            addToCartPage.clickCartPlaceOrderPurchaseBtn();
            logger.info("Purchase Completed");
            addToCartPage.clickCartPurchaseConfirmationBtn();
        }
        catch (Exception e){
            ScreenshotUtil.captureScreenshot(driver, "testCartPageWithoutAccount_Error");
            logger.error("Add to Cart Test failed due to an error:", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

    }
}
