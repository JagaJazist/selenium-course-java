import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";

    @Test
    public void testRegistration() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("[name=login_form] a")).click();
        wait.until(titleIs("Create Account | My Store"));

        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Name");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Lastname");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("123 Building");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("35010");
        Select select = new Select(driver.findElement(By.cssSelector("[name=country_code]")));
        select.selectByVisibleText("United States");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Alexander City");
        String email = "email_" + System.currentTimeMillis() + "@email.com";
        System.out.println(email);
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+18033456789");
        String password = "password";
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);

        driver.findElement(By.cssSelector("[name=create_account]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Logout"))));
        driver.findElement(By.linkText("Logout")).click();

        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=login]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Logout"))));
        driver.findElement(By.linkText("Logout")).click();
    }

    private void loginToAdmin() {
        driver.get(BASE_URL);

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin");

        WebElement login = driver.findElement(By.name("login"));
        login.click();
    }

    private class Country {

        public Country(String name, String zones){
            this.name = name;
            this.zones = zones;
        }

        String name;
        String zones;
    }
}
