import Pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class FirstTest extends TestBase {

    @Test
    public void testCart() {

        MainPage mainPage = new MainPage(driver);
        mainPage.addProductToCart(3);

        driver.findElement(By.linkText("Checkout »")).click();

        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".shortcut"))));
                driver.findElement(By.cssSelector(".shortcut")).click();
            }
            WebElement button = driver.findElement(By.cssSelector("[name=remove_cart_item]"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("#checkout-summary-wrapper td.item"))));
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#checkout-cart-wrapper p em"))));
    }
}
