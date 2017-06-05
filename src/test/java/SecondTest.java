import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SecondTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/acme-corp-m-1/";

    @Test
    public void testOnlyOneStickerIsShown() {
        driver.get(BASE_URL);

        List<WebElement> products = driver.findElements(By.cssSelector(".products li"));
        for (WebElement product : products) {
            int stickersNum = product.findElements(By.cssSelector(".sticker")).size();
            Assert.assertEquals(1, stickersNum);
        }
    }

}
