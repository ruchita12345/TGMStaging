package web.test;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemAddedToCartPopUpPage;

import static extentlisteners.ExtentListeners.test;

public class ItemAddedToCartPopUp extends TestBase {
    ItemAddedToCartPopUpPage itemAddedToCartPopUpPage;

    public ItemAddedToCartPopUp() {
        super();
    }

    @BeforeClass
    public void setup() {
        TestBase.initialization();
        itemAddedToCartPopUpPage = new ItemAddedToCartPopUpPage();
    }

    @Test(priority = 3)
    public void isProductImageInCartPopupDisplayed() {
        itemAddedToCartPopUpPage.selectAvailableProduct();
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verified if Product image is displayed in Cart Pop up");
        Assert.assertTrue(itemAddedToCartPopUpPage.isImageInCartPopupDisplayed(), "Image is not displayed in the Cart popup");
    }

    @Test(priority = 4)
    public void verifyProductNameInCartPopUp() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verified Product name in Cart Pop up");
        Assert.assertEquals(itemAddedToCartPopUpPage.getProductNameInCartPopUp(), ItemAddedToCartPopUpPage.productTitleExpected,
                "Wrong Product Name added in Cart pop up");
    }

    @Test(priority = 5)
    public void verifyProductColorInCartPopUp() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verified Product color in Cart Pop up");
        Assert.assertEquals(itemAddedToCartPopUpPage.getProductColorInCartPopUp(), ItemAddedToCartPopUpPage.productColorExpected,
                "Wrong Product Color added in Cart pop up");
    }

    @Test(priority = 6)
    public void verifyProductSizeInCartPopUp() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verified Product size in Cart Pop up");
        Assert.assertEquals(itemAddedToCartPopUpPage.getProductSizeInCartPopUp(), ItemAddedToCartPopUpPage.productSizeExpected,
                "Wrong Product Size added in Cart pop up");
    }

    @Test(priority = 7)
    public void verifyCartCountBubble() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Verified number of products displayed in Cart Count Bubble");
        Assert.assertEquals(itemAddedToCartPopUpPage.getCartCountBubble(), "2",
                "Wrong number of products displayed in Cart Count Bubble");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
