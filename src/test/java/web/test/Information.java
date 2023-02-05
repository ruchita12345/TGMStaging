package web.test;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InformationPage;
import pages.YourCartPage;

import static extentlisteners.ExtentListeners.test;

public class Information extends TestBase {
    InformationPage informationPage;

    public Information() {
        super();
    }

    @BeforeClass
    public void setup() {
        TestBase.initialization();
        informationPage = new InformationPage();
    }

    @Test(priority = 12)
    public void verifyValidDiscountCodeErrorMessage() {
        YourCartPage yourCartPage = new YourCartPage();
        yourCartPage.selectAvailableProductAndCheckout();
        informationPage.clickOnCheckoutCTA();
        informationPage.enterDiscountCodeAndApply("MICKY10");

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Apply Valid Discount Code");
        test.log(Status.INFO, "Verified if Discount Code is applied");
        Assert.assertTrue(informationPage.isDiscountCodeApplied(), "Discount code is not applied");
    }

    @Test(priority = 13)
    public void verifyInvalidDiscountCodeErrorMessage() {
        informationPage.enterDiscountCodeAndApply("INVALID");

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Apply Invalid Discount Code");
        test.log(Status.INFO, "Verified Discount code error msg is displayed ");
        Assert.assertTrue(informationPage.isDiscountCodeErrorMessageDisplayed(), "Discount code error msg is not displayed");
    }

    @Test(priority = 14)
    public void verifyMandatoryFieldsOfShippingAddress() {
        informationPage.clickOnContinueToShippingCTA();

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Do not enter mandatory fields of Shipping address");
        test.log(Status.INFO, "Click on Continue to Shipping CTA");
        test.log(Status.INFO, "Verified Mandatory fields of Shipping Address");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(informationPage.isLastNameErrorMessageDisplayed(), "Mandatory field validation is not applied for Last Name");
        softAssert.assertTrue(informationPage.isAddressErrorMessageDisplayed(), "Mandatory field validation is not applied for Address");
        softAssert.assertTrue(informationPage.isCityErrorMessageDisplayed(), "Mandatory field validation is not applied for Last City");
        softAssert.assertFalse(informationPage.isEmirateErrorMessageDisplayed(), "Mandatory field validation is applied for Last Name even though the Emirate is pre-selected");
        softAssert.assertTrue(informationPage.isPhoneErrorMessageDisplayed(), "Mandatory field validation is not applied for Phone Number");
        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void verifyMandatoryFieldOfEmailId() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Do not enter mandatory fields of Email ID");
        test.log(Status.INFO, "Click on Continue to Shipping CTA");
        test.log(Status.INFO, "Verified Mandatory fields of Email ID");
        Assert.assertTrue(informationPage.isEmailErrorMsgDisplayed(), "Mandatory field validation is not applied for Email ID");
    }

    @Test(priority = 16)
    public void verifyContactInShippingAddress() {
        informationPage.enterEmailID("ruch.solanki@gmail.com");
        informationPage.enterLastName("Solanki");
        informationPage.enterAddress("501");
        informationPage.enterCity("Dubai");
        informationPage.enterPhone("0577895567");
        informationPage.selectEmirate("Dubai");
        informationPage.clickOnContinueToShippingCTA();

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Enter Email ID and continue to Shipping information");
        test.log(Status.INFO, "Verified Email ID displayed");
        Assert.assertEquals(informationPage.getContactEmailID(), "ruch.solanki@gmail.com" , "Wrong email ID displayed");
    }

    @Test(priority = 17)
    public void verifyShipToShippingAddress() {
        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Enter Shipping address and continue to Shipping information");
        test.log(Status.INFO, "Verified Ship to");
        Assert.assertEquals(informationPage.getShipTo(), "501, Dubai DU, United Arab Emirates" , "Wrong Shipping Info displayed");
    }

    @Test(priority = 18)
    public void makePayment() {
        informationPage.enterCreditCardDetails();
        informationPage.enterCardNumber("4242 4242 4242 4242");
        informationPage.enterCardHolderName("Ruchita Solanki");
        informationPage.enterExpirationDate("12/24");
        informationPage.enterCVV("100");
        informationPage.clickOnPayNOWCTA();

        test.log(Status.INFO, "Add an Item to Cart");
        test.log(Status.INFO, "Enter Shipping address and continue to Payment");
        test.log(Status.INFO, "Enter Credit Card details and Pay");
        Assert.assertFalse(informationPage.isCardDeclineMsgDisplayed() , "Credit card declined");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
