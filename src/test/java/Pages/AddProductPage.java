package Pages;

import Models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddProductPage extends PageBase {
    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Product product) {
        fillIsEnabled(product.isEnabled);
        fillName(product.name);
        fillCode(product.code);
        fillImageLink(product.imageLink);
        openInformationTab();
        fillManufacturer(product.manufacturer);
    }

    private void fillManufacturer(String manufacturer) {
        Select select = new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]")));
        select.selectByVisibleText(manufacturer);
    }

    private void fillImageLink(String imageLink) {
        driver.findElement(By.cssSelector("[name^=new_images]")).sendKeys(imageLink);
    }

    private void fillCode(String code) {
        driver.findElement(By.cssSelector("[name=code]")).sendKeys(code);
    }

    private void fillName(String name) {
        driver.findElement(By.cssSelector("[name^=name]")).sendKeys(name);
    }

    private void fillIsEnabled(boolean isEnabled) {
        if(isEnabled) {
            driver.findElement(By.cssSelector("[name=status]:nth-of-type(1)")).click();
        } else {
            driver.findElement(By.cssSelector("[name=status]:nth-of-type(2)")).click();
        }
    }

    private void openInformationTab() {
        driver.findElement(By.linkText("Information")).click();
    }

}
