package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebUtil;

import static util.WebUtil.clickOn;

public class YourCartPage extends TestBase {

    @FindBy(css = ".cart-notification-product__image.global-media-settings  img")
    private WebElement imageInCartPopup;

    @FindBy(css = "#product-grid li:nth-child(10)")
    private WebElement availableProduct;
    @FindBy(css = "button[name=\"add\"]")
    private WebElement addToCartCTA;
    @FindBy(css = "#cart-notification-button")
    private WebElement viewMyCartCTA;
    @FindBy(css = "a.underlined-link")
    private WebElement continueShoppingLink;
    @FindBy(css = ".cart-item__details > div.product-option")
    private WebElement itemPrice;
    @FindBy(css = ".quantity__input")
    private WebElement itemQuantity;
    @FindBy(css = ".cart-item__totals.right.small-hide span")
    private WebElement totalItemPrice;
    @FindBy(css = ".totals__subtotal-value")
    private WebElement subTotalPrice;
    @FindBy(css = "button[name=minus]")
    private WebElement reduceItem;
    @FindBy(css = "#product-grid")
    private WebElement productCatalogs;
    @FindBy(css = "button._2pOWh.uWTUp._1Kqoj._2tVwl._276ql._10zXD.sd4hU")
    private WebElement continueToShoppingCTA;



    public YourCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectAvailableProductAndCheckout() {
        SoldOutProductPage soldOutProductPage = new SoldOutProductPage();
        ItemAddedToCartPopUpPage itemAddedToCartPopUpPage = new ItemAddedToCartPopUpPage();
        soldOutProductPage.clickOnCatalog();
        clickOn(availableProduct);
        itemAddedToCartPopUpPage.increaseQuantity();
        clickOn(addToCartCTA);
        clickOn(viewMyCartCTA);
    }

    public void reduceItem() {
        clickOn(reduceItem);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getItemPrice() {
        String getItemPrice = WebUtil.getText(itemPrice);
        String getItemPriceWithDecimal = getItemPrice.split(" ")[1].replace(",", "");
        return Integer.parseInt(getItemPriceWithDecimal.substring(0, getItemPriceWithDecimal.length() - 3));
    }

    public int getTotalItemPriceExpected() {
        return getItemPrice() * Integer.parseInt(WebUtil.getAttribute(itemQuantity, "value"));
    }

    public int getTotalPriceActual() {
        String totalPriceActual = WebUtil.getText(totalItemPrice);
        String getTotalItemPriceWithDecimal = totalPriceActual.split(" ")[1].replace(",", "");
        return Integer.parseInt(getTotalItemPriceWithDecimal.substring(0, getTotalItemPriceWithDecimal.length() - 3));
    }

    public int getSubTotalItemPriceActual() {
        String totalPriceActual = WebUtil.getText(subTotalPrice);
        String getTotalItemPriceWithDecimal = totalPriceActual.split(" ")[1].replace(",", "");
        return Integer.parseInt(getTotalItemPriceWithDecimal.substring(0, getTotalItemPriceWithDecimal.length() - 3));
    }

    public void clickOnContinueShopping() {
        clickOn(continueShoppingLink);
    }

    public boolean isProductCatalogPageDisplayed() {
        return WebUtil.isDisplayed(productCatalogs);
    }

    public void clickOnContinueToShopping() {
        clickOn(continueToShoppingCTA);
    }
}
