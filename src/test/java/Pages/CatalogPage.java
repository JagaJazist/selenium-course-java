package Pages;

import Models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends PageBase {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void openNewProductPage() {
        driver.findElement(By.cssSelector(".button:nth-of-type(2)")).click();
    }

    public void openProduct(Product product) {
        driver.findElement(By.linkText(product.name)).click();
    }
}
