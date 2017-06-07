import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SecondTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";

    @Test
    public void testOnlyOneStickerIsShown() {
        driver.get(BASE_URL);

        driver.findElement(By.cssSelector("#box-campaigns img")).click();

        String name = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        String regularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        String campaignPrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();

        String color = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");

        String regularPriceTagName = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();

        String campaignPriceTagName = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();

        System.out.println(campaignPriceTagName);

    }

}
