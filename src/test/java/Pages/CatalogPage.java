package Pages;

import Models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends PageBase {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void openNewProductPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".button:nth-of-type(2)"))));
        driver.findElement(By.cssSelector(".button:nth-of-type(2)")).click();
    }

    public void openProduct(Product product) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(product.name))));
        driver.findElement(By.linkText(product.name)).click();
    }
}
