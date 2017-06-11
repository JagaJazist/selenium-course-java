package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMainPage extends PageBase {
    public static final String BASE_URL = "http://localhost:8899/public_html/admin/";

    public AdminMainPage(WebDriver driver) {
        super(driver);
    }

    public void openCatalog() {
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(2)" )).click();
    }
}