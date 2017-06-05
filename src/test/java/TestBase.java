import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by apostnov on 05/06/2017.
 */
public class TestBase {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 1);
    }

    boolean isElementPresent (By locator) {
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
