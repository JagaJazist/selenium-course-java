package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToAdminPage extends PageBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/";

    public LoginToAdminPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void loginAsAdmin() {
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.name("login"));
        login.click();
    }
}
