import apple.laf.JRSUIConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.refreshed;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by apostnov on 26/05/2017.
 */
public class FirstTest {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/";

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 1);
    }

    @Test
    public void testAdminLogin() {
        login();

        int primaryLinksNumber = driver.findElements(By.cssSelector("ul#box-apps-menu li")).size();
        System.out.println("Primary: " + primaryLinksNumber);

        for (int i = 1; i <= primaryLinksNumber; i++) {
            WebElement primaryLink = driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") a"));
            System.out.println(primaryLink.getText());
            primaryLink.click();

            if (isElementPresent(By.cssSelector(".docs"))) {
                int secondaryLinksNumber = driver.findElements(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") a ")).size();
                System.out.println(secondaryLinksNumber);

                for (int j = 2; j < secondaryLinksNumber; j++) {
                    WebElement secondaryLink = driver.findElement(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") li:nth-of-type(" + j + ") a"));
                    System.out.println("Secondary: " + secondaryLink.getText());
                    wait.until(ExpectedConditions.visibilityOf(secondaryLink));
                    secondaryLink.click();
                    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("#box-apps-menu li:nth-of-type(" + i + ") li:nth-of-type(" + j + ")"),"class", "selected"));
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

        Assert.assertEquals("Wrong title","My Store", driver.getTitle());
    }

    private boolean isElementPresent (By locator) {
        try {
            wait.until((WebDriver d) -> (d.findElement(locator)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
