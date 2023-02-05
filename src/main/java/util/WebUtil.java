package util;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil extends TestBase {
    public static long EXPLICITLY_WAIT =30;

    public static void clickOn(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitUntilElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static String getText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static boolean isDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();

    }

    public static String getAttribute(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(value);
    }

    public static void typeInto(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(value);
    }

    public static void selectFromDropDown(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        Select se = new Select(element);
        se.selectByVisibleText(value);
    }

    public static void switchToFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }
}
