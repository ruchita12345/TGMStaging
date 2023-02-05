package web.test;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YourCartPage;

import static extentlisteners.ExtentListeners.test;

public class YourCart extends TestBase {
    YourCartPage yourCartPage;

    public YourCart() {
        super();
    }

    @BeforeClass
    public void setup() {
        TestBase.initialization();
        yourCartPage = new YourCartPage();
    }

    @Test(priority = 8)
    public void verifyTotalAmount() {
        yourCartPage.selectAvailableProductAndCheckout();

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verify the Total Amount in the Cart");
        Assert.assertEquals(yourCartPage.getTotalPriceActual() ,yourCartPage.getTotalItemPriceExpected(), "Total in the cart is wrong");
    }

    @Test(priority = 9)
    public void verifyTotalAmountAfterReducingItem() {
        yourCartPage.reduceItem();

        test.log(Status.INFO, "Add multiple Item to Cart");
        test.log(Status.INFO, "Reduce an Item from Cart");
        test.log(Status.INFO, "Verify the Total Amount in the Cart");
        Assert.assertEquals(yourCartPage.getTotalPriceActual() ,yourCartPage.getTotalItemPriceExpected(), "Total in the cart is wrong");
    }

    @Test(priority = 10)
    public void verifySubTotal() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verify the Subtotal in Cart");
        Assert.assertEquals(yourCartPage.getSubTotalItemPriceActual(), yourCartPage.getTotalItemPriceExpected(), "Sub- Total in the cart is wrong");
    }

    @Test(priority = 11)
    public void verifyContinueShopping() {
        yourCartPage.clickOnContinueShopping();

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Click on Continue to Shopping link");
        test.log(Status.INFO, "Verified that the user is redirected to Product Catalogs page");
        Assert.assertTrue(yourCartPage.isProductCatalogPageDisplayed(), "User is not redirected to Products page");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
