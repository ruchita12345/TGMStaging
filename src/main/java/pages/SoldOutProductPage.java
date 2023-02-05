package pages;

import base.TestBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static extentlisteners.ExtentListeners.test;
import static util.WebUtil.*;

public class SoldOutProductPage extends TestBase {
    @FindBy(css = ".list-menu.list-menu--inline li:nth-child(2) a")
    private WebElement catalog;
    @FindBy(css = "#product-grid li:nth-child(1)")
    private WebElement soldOutProduct;
    @FindBy(css = "#SortBy")
    private WebElement sortByFilter;
    @FindBy(css = ".product-form__submit.button.button--full-width.button--secondary")
    private WebElement soldOut;
    @FindBy(css = ".shopify-payment-button__button.shopify-payment-button__button--unbranded")
    private WebElement buyItNow;

    public SoldOutProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCatalog() {
        waitUntilElementDisplayed(catalog);
        test.log(Status.INFO, "Clicked On Catalog");
    }

    public void selectSoldOutProduct() {
        clickOn(soldOutProduct);
        test.log(Status.INFO, "Sold out product selected");
    }

    public Boolean isBuyItNowCTADisabled() {
        return buyItNow.isEnabled();
    }

    public Boolean isSoldOutCTAEnabled() {
        return soldOut.isEnabled();
    }
}
