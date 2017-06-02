import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testAdminLogin() {
        driver.get(BASE_URL);

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.name("login"));
        login.click();

        wait.until(titleIs("My Store"));

        Assert.assertEquals("Wrong title","My Store", driver.getTitle());

        for (int i = 1; i < 18; i++) {
            WebElement element = driver.findElement(By.cssSelector("ul#box-apps-menu li:nth-of-type(" + i + ") a"));
            System.out.println(element.getText());
            element.click();
        }


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
