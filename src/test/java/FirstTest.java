import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";

    @Test
    public void testCart() {
        for (int i = 1; i < 4; i++) {
            driver.get(BASE_URL);
            driver.findElement(By.cssSelector("#box-most-popular li:nth-of-type(" + i + ")")).click();
            if (driver.findElements(By.cssSelector("[name^=options]")).size() > 0) {
                Select select = new Select(driver.findElement(By.cssSelector("[name^=options]")));
                select.selectByIndex(1);
            }
            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
            wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), String.valueOf(i)));
        }

        driver.findElement(By.linkText("Checkout »")).click();

        for (int i = 0; i < 3; i++) {
            if (i != 2) {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".shortcut"))));
                driver.findElement(By.cssSelector(".shortcut")).click();
            }
            WebElement button = driver.findElement(By.cssSelector("[name=remove_cart_item]"));
            wait.until(ExpectedConditions.visibilityOf(button));
            button.click();
            wait.until(ExpectedConditions.invisibilityOf(button));
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#checkout-cart-wrapper p em"))));
    }
}
