package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ProductPage extends PageBase {

    @FindBy(css = "[name=add_cart_product]")
    WebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSizeIfNeeded() {
        if (driver.findElements(By.cssSelector("[name^=options]")).size() > 0) {
            Select select = new Select(driver.findElement(By.cssSelector("[name^=options]")));
            select.selectByIndex(1);
        }
    }

    public void addToCart() {
        addToCart.click();
    }
}
