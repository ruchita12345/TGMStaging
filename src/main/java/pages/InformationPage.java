package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.WebUtil.*;

public class InformationPage extends TestBase {

    @FindBy(css = ".cart__checkout-button.button")
    private WebElement checkOutCTA;
    @FindBy(css = "#TextField0")
    private WebElement discountCodeTextBox;
    @FindBy(css = "._2pOWh.uWTUp._3RHG2._276ql.sd4hU._2aRQj")
    private WebElement discountCodeApplyCTA;
    @FindBy(css = "li._1fragem1a._1fragemcx")
    private WebElement appliedDiscountCode;
    @FindBy(css = "#error-for-TextField0")
    private WebElement discountErrorCode;
    @FindBy(css = "button._2pOWh.uWTUp._1Kqoj._2tVwl._276ql._10zXD.sd4hU")
    private WebElement continueToShippingCTA;
    @FindBy(css = "#error-for-email")
    private WebElement emailError;
    @FindBy(css = "#error-for-TextField2")
    private WebElement lastNameError;
    @FindBy(css = "#error-for-email")
    private WebElement addressError;
    @FindBy(css = "#error-for-TextField6")
    private WebElement cityError;
    @FindBy(css = "#error-for-TextField7")
    private WebElement phoneError;
    @FindBy(css = "#email")
    private WebElement emailTextBox;
    @FindBy(css = "#TextField2")
    private WebElement lastNameTextBox;
    @FindBy(css = "#TextField4")
    private WebElement addressTextBox;
    @FindBy(css = "#TextField6")
    private WebElement cityTextBox;
    @FindBy(css = "#Select1")
    private WebElement emirateDropDown;
    @FindBy(css = "#TextField7")
    private WebElement phoneTextBox;
    @FindBy(css = "bdo[class='_19gi7yt0 _19gi7ytg _1fragem1t']")
    private WebElement contactEmailID;
    @FindBy(css = "address[class='_19gi7yt0 _19gi7ytg _1fragem1t']")
    private WebElement shipTo;
    @FindBy(css = "input[placeholder='Card number']")
    private WebElement cardNumber;
    @FindBy(css = "input[placeholder='Cardholder name']")
    private WebElement cardHolderName;
    @FindBy(css = "input[placeholder='Expiration date (MM / YY)']")
    private WebElement expirationDate;
    @FindBy(css = "input[placeholder='Security code']")
    private WebElement cvv;
    @FindBy(css = "#checkout-main div._3XHWd._7J8O button[type=submit]")
    private WebElement continueToPaymentCTA;
    @FindBy(css = "div._3XHWd._7J8O button")
    private WebElement payNowCTA;
    @FindBy(css = "div.uReyx div[role=alert]")
    private WebElement cardDeclinedMsg;
    @FindBy(css = "iframe[title='Field container for: Card number']")
    private WebElement cardNumberIframe;
    @FindBy(css = "iframe[title='Field container for: Cardholder name']")
    private WebElement cardHolderNameIframe;
    @FindBy(css = "iframe[title='Field container for: Expiration date (MM / YY)'] ")
    private WebElement cardExpirationDateIframe;
    @FindBy(css = "iframe[title='Field container for: Security code'] ")
    private WebElement cardCVVIframe;

    public InformationPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutCTA() {
        clickOn(checkOutCTA);
    }

    public void enterDiscountCodeAndApply(String discountCode) {
        typeInto(discountCodeTextBox, discountCode);
        clickOn(discountCodeApplyCTA);
    }

    public boolean isDiscountCodeApplied() {
        return isDisplayed(appliedDiscountCode);
    }

    public boolean isDiscountCodeErrorMessageDisplayed() {
        return isDisplayed(discountErrorCode);
    }

    public boolean isEmailErrorMsgDisplayed() {
        return isDisplayed(emailError);
    }

    public boolean isLastNameErrorMessageDisplayed() {
        return isDisplayed(lastNameError);
    }

    public boolean isAddressErrorMessageDisplayed() {
        return isDisplayed(addressError);
    }

    public boolean isCityErrorMessageDisplayed() {
        return isDisplayed(cityError);
    }

    public boolean isEmirateErrorMessageDisplayed() {
        return isDisplayed(emailError);
    }

    public boolean isPhoneErrorMessageDisplayed() {
        return isDisplayed(phoneError);
    }

    public void clickOnContinueToShippingCTA() {
        clickOn(continueToShippingCTA);
    }

    public void enterEmailID(String emailID) {
        typeInto(emailTextBox, emailID);
    }

    public void enterLastName(String lastName) {
        typeInto(lastNameTextBox, lastName);
    }

    public void enterAddress(String address) {
        typeInto(addressTextBox, address);
    }

    public void enterCity(String city) {
        typeInto(cityTextBox, city);
    }

    public void enterPhone(String phone) {
        typeInto(phoneTextBox, phone);
    }

    public void selectEmirate(String emirate) {
        selectFromDropDown(emirateDropDown, emirate);
    }

    public String getContactEmailID() {
        return getText(contactEmailID);
    }

    public String getShipTo() {
        return getText(shipTo);
    }

    public void enterCreditCardDetails() {
        clickOn(continueToPaymentCTA);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterCardNumber(String cardNumber) {
        switchToFrameByElement(cardNumberIframe);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", cardNumber, this.cardNumber);
        driver.switchTo().defaultContent();
    }

    public void enterCardHolderName(String cardHolderName) {
        switchToFrameByElement(cardHolderNameIframe);
        typeInto(this.cardHolderName, cardHolderName);
        driver.switchTo().defaultContent();
    }

    public void enterExpirationDate(String expirationDate) {
        switchToFrameByElement(cardExpirationDateIframe);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", expirationDate, this.expirationDate);
        driver.switchTo().defaultContent();
    }

    public void enterCVV(String cvv) {
        switchToFrameByElement(cardCVVIframe);
        typeInto(this.cvv, cvv);
        driver.switchTo().defaultContent();
    }

    public void clickOnPayNOWCTA() {
        clickOn(payNowCTA);
    }

    public boolean isCardDeclineMsgDisplayed() {
        return isDisplayed(cardDeclinedMsg);
    }
}
