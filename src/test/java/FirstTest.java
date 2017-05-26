import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by apostnov on 26/05/2017.
 */
public class FirstTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testAdminLogin() {
        driver.get("http://localhost:8899/public_html/admin/");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.name("login"));
        login.click();
        wait.until(driver.getTitle() == "My Store");

        Assert.assertEquals("My Store", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
