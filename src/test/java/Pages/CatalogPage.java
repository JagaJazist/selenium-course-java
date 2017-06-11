package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rcc on 10.06.17.
 */
public class CatalogPage extends PageBase {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void openNewProductPage() {
        driver.findElement(By.cssSelector(".button:nth-of-type(2)")).click();
    }
}
