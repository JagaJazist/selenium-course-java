package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminMainPage extends PageBase {
    public static final String BASE_URL = "http://localhost:8899/public_html/admin/";

    public AdminMainPage(WebDriver driver) {
        super(driver);
    }

    public void openCatalog() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#box-apps-menu li:nth-of-type(2)")));
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(2)" )).click();
    }
}