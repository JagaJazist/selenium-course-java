import Pages.LoginToAdminPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/?app=countries&doc=countries";

    @Test
    public void testNewWindows() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.open();
        loginToAdminPage.loginAsAdmin();

        driver.get(BASE_URL);
        driver.findElement(By.cssSelector(".fa.fa-plus-circle")).click();

        List<WebElement> links = driver.findElements(By.xpath("//*[contains(@class, 'fa-external-link')]/.."));

        for (WebElement link : links) {
            Assert.assertEquals("_blank", link.getAttribute("target"));

            String firstWindowHandle = driver.getWindowHandle();
            link.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> allWindowHandles = driver.getWindowHandles();
            allWindowHandles.remove(firstWindowHandle);
            driver.switchTo().window((String) allWindowHandles.toArray()[0]);
            driver.close();
            driver.switchTo().window(firstWindowHandle);
        }
    }
}
