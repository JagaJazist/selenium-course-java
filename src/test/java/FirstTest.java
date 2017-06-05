import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/";

    @Test
    public void testMenuLinks() {
        login();

        int primaryLinksNumber = driver.findElements(By.cssSelector("ul#box-apps-menu li")).size();

        for (int i = 1; i <= primaryLinksNumber; i++) {
            WebElement primaryLink = driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") a"));
            primaryLink.click();

            if (isElementPresent(By.cssSelector(".docs"))) {
                int secondaryLinksNumber = driver.findElements(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") a ")).size();
                for (int j = 2; j < secondaryLinksNumber; j++) {
                    WebElement secondaryLink = driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") li:nth-of-type(" + j + ") a"));
                    wait.until(ExpectedConditions.visibilityOf(secondaryLink));
                    secondaryLink.click();
                    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") li:nth-of-type(" + j + ")"), "class", "selected"));
                }
            }

            Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
            driver.get(BASE_URL);
        }
    }

    private void login() {
        driver.get(BASE_URL);

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.name("login"));
        login.click();

        wait.until(titleIs("My Store"));

        Assert.assertEquals("Wrong title", "My Store", driver.getTitle());
    }
}
