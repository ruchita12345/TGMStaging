package web.test;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SoldOutProductPage;

import static extentlisteners.ExtentListeners.test;

public class SoldOutProduct extends TestBase {
    SoldOutProductPage soldOutProductPage;

    public SoldOutProduct() {
        super();
    }

    @BeforeClass
    public void setup() {
        TestBase.initialization();
        soldOutProductPage = new SoldOutProductPage();
    }

    @Test(priority=1)
    public void addToCartIsDisabled() {
        soldOutProductPage.clickOnCatalog();
        soldOutProductPage.selectSoldOutProduct();

        test.log(Status.INFO, "Verified if \"Add to cart\" CTA is disabled");
        Assert.assertFalse(soldOutProductPage.isSoldOutCTAEnabled(), "\"Add to cart\" CTA is not disabled");
    }

    @Test(priority=2)
    public void buyItNowIsDisabled() {
        test.log(Status.INFO, "Verified if \"Buy it Now\" CTA is disabled");
        Assert.assertFalse(soldOutProductPage.isBuyItNowCTADisabled(), "\"Buy it Now\" CTA is not disabled");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
