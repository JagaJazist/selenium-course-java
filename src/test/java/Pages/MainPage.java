package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageBase {

    @FindBy(linkText = "Checkout »")
    WebElement checkout;

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void addProductsToCart(int numberOfProducts) {
        for (int i = 1; i <= numberOfProducts; i++) {
            this.open();
            openPopularProduct(i);
            ProductPage productPage = new ProductPage(driver);
            productPage.selectSizeIfNeeded();
            productPage.addToCart();
            waitUntilProductIsInCart(i);
        }
    }

    private void waitUntilProductIsInCart(int i) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), String.valueOf(i)));
    }

    private void openPopularProduct(int position) {
        driver.findElement(By.cssSelector("#box-most-popular li:nth-of-type(" + position + ")")).click();
    }

    public void checkout(){
        checkout.click();
    }
}
