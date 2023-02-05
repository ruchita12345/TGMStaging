package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.WebUtil.*;

public class ItemAddedToCartPopUpPage extends TestBase {
    @FindBy(css = ".cart-notification-product__image.global-media-settings  img")
    private WebElement imageInCartPopup;
    @FindBy(css = ".cart-notification-product__name.h4")
    private WebElement productNameInCartPopUp;
    @FindBy(css = "#cart-notification-product dl div:nth-child(1) dd")
    private WebElement productColorInCartPopUp;
    @FindBy(css = "#cart-notification-product dl div:nth-child(2) dd")
    private WebElement productSizeInCartPopUp;
    @FindBy(css = ".cart-count-bubble span:nth-child(1)")
    private WebElement cartCountBubble;

    @FindBy(css = ".product__title h1")
    private WebElement productTitle;
    @FindBy(css = "label[for=\"template--16018054021277__main-1-0\"]")
    private WebElement productColor;
    @FindBy(css = "label[for=\"template--16018054021277__main-2-0\"]")
    private WebElement productSize;
    @FindBy(css = "button[name=\"plus\"]")
    private WebElement quantityPlus;
    @FindBy(css = "#product-grid li:nth-child(10)")
    private WebElement availableProduct;
    @FindBy(css = "button[name=\"add\"]")
    private WebElement addToCartCTA;

    public ItemAddedToCartPopUpPage() {
        PageFactory.initElements(driver, this);
    }

    public static String productTitleExpected;
    public static String productSizeExpected;
    public static String productColorExpected;

    public void selectAvailableProduct() {
        SoldOutProductPage soldOutProductPage = new SoldOutProductPage();
        soldOutProductPage.clickOnCatalog();
        clickOn(availableProduct);
        productTitleExpected = getProductTitle();
        productSizeExpected = getProductSize();
        productColorExpected = getProductColor();
        increaseQuantity();
        clickOn(addToCartCTA);
    }

    public void increaseQuantity() {
        clickOn(quantityPlus);
    }

    public String getProductColor() {
        return getText(productColor);
    }

    public String getProductSize() {
        return getText(productSize);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public boolean isImageInCartPopupDisplayed() {
        return isDisplayed(imageInCartPopup);
    }

    public String getProductNameInCartPopUp() {
        return getText(productNameInCartPopUp);
    }

    public String getProductColorInCartPopUp() {
        return getText(productColorInCartPopUp);
    }

    public String getProductSizeInCartPopUp() {
        return getText(productSizeInCartPopUp);
    }

    public String getCartCountBubble() {
        return getText(cartCountBubble);
    }
}
