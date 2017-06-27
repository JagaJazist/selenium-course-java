package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage extends PageBase {

    @FindBy(css = ".shortcut")
    WebElement shortcut;

    @FindBy(css = "[name=remove_cart_item]")
    WebElement remove;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteProductFromCart(int numberOfProducts) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i < numberOfProducts; i++) {
            if (i != numberOfProducts - 1) {
                wait.until(ExpectedConditions.visibilityOf(shortcut));
                shortcut.click();
            }
            wait.until(ExpectedConditions.visibilityOf(remove));
            remove.click();
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("#checkout-summary-wrapper td.item"))));
        }
    }

    public void waitUntilCartIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#checkout-cart-wrapper p em"))));
    }
}
