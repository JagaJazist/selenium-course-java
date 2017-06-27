package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void addProductToCart(int numberOfProducts) {
        for (int i = 1; i <= numberOfProducts; i++) {
            open();
            driver.findElement(By.cssSelector("#box-most-popular li:nth-of-type(" + i + ")")).click();
            if (driver.findElements(By.cssSelector("[name^=options]")).size() > 0) {
                Select select = new Select(driver.findElement(By.cssSelector("[name^=options]")));
                select.selectByIndex(1);
            }
            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), String.valueOf(i)));
        }
    }

    public void checkout(){

    }
}
