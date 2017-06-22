import Pages.LoginToAdminPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/?app=catalog&doc=catalog&category_id=1:";

    @Test
    public void testBrowserLogs() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.open();
        loginToAdminPage.loginAsAdmin();

        driver.get(BASE_URL);

        int productsNum = driver.findElements(By.xpath("//*[contains(@class, 'dataTable')]//img/following-sibling::a")).size();

        for (int i = 0; i < productsNum; i++) {
            driver.findElements(By.xpath("//*[contains(@class, 'dataTable')]//img/following-sibling::a")).get(i).click();
            Assert.assertTrue(driver.manage().logs().get("browser").getAll().isEmpty());
            driver.get(BASE_URL);
        }
    }
}
