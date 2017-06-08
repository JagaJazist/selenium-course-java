import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SecondTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/en/";


    @Test
    public void testProductTitlesMatch() {
        driver.get(BASE_URL);
        String nameOnFirstPage = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        driver.findElement(By.cssSelector("#box-campaigns img")).click();
        String nameOnProductPage = driver.findElement(By.cssSelector("#box-product .title")).getText();
        Assert.assertEquals(nameOnFirstPage, nameOnProductPage);
    }

    @Test
    public void testProductPricesMatch() {
        driver.get(BASE_URL);
        String regularPriceFirstPage = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        String campaignPriceFirstPage = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();

        driver.findElement(By.cssSelector("#box-campaigns img")).click();

        String regularPriceProductPage = driver.findElement(By.cssSelector("#box-product .regular-price")).getText();
        String campaignPriceProductPage = driver.findElement(By.cssSelector("#box-product .campaign-price")).getText();

        Assert.assertEquals(regularPriceFirstPage, regularPriceProductPage);
        Assert.assertEquals(campaignPriceFirstPage, campaignPriceProductPage);
    }

    @Test
    public void testRegularPriceStyle() {
        driver.get(BASE_URL);
        String regularPriceTagName = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
        Assert.assertEquals("s", regularPriceTagName);

        Color regularPriceColor = parseColor(driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color"));

        boolean isPriceGrey = (regularPriceColor.getBlue() == regularPriceColor.getGreen()) &&(regularPriceColor.getGreen() == regularPriceColor.getRed());
        Assert.assertTrue(isPriceGrey);

        driver.findElement(By.cssSelector("#box-campaigns img")).click();


        Color regularPriceColorOnProductPage = parseColor(driver.findElement(By.cssSelector("#box-product .regular-price")).getCssValue("color"));
        boolean isPriceGreyOnProductPage = (regularPriceColorOnProductPage.getBlue() == regularPriceColorOnProductPage.getGreen())
                && (regularPriceColorOnProductPage.getGreen() == regularPriceColorOnProductPage.getRed());
        Assert.assertTrue(isPriceGreyOnProductPage);
    }

    @Test
    public void testCampaignPriceStyle() {
        driver.get(BASE_URL);
        String campaignPriceTagName = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
        Assert.assertEquals("strong", campaignPriceTagName);

        Color campaignPriceColor = parseColor(driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color"));
        boolean isPriceRed = (campaignPriceColor.getBlue() == 0) && (campaignPriceColor.getGreen() == 0);
        Assert.assertTrue(isPriceRed);

        driver.findElement(By.cssSelector("#box-campaigns img")).click();

        Color campaignPriceColorOnProductPage = parseColor(driver.findElement(By.cssSelector("#box-product .campaign-price")).getCssValue("color"));
        boolean isPriceRedOnProductPage = (campaignPriceColorOnProductPage.getBlue() == 0) && (campaignPriceColorOnProductPage.getGreen() == 0);
        Assert.assertTrue(isPriceRedOnProductPage);
    }


    @Test
    public void testPricesSize() {
        driver.get(BASE_URL);

        Dimension regularPriceSize = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getSize();
        Dimension campaignPriceSize = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getSize();

        boolean result = (regularPriceSize.getHeight() < campaignPriceSize.getHeight()
                            && regularPriceSize.getWidth() < campaignPriceSize.getWidth());
        Assert.assertTrue(result);

        driver.findElement(By.cssSelector("#box-campaigns img")).click();

        Dimension regularPriceSizeProductPage = driver.findElement(By.cssSelector("#box-product .regular-price")).getSize();
        Dimension campaignPriceSizeProductPage = driver.findElement(By.cssSelector("#box-product .campaign-price")).getSize();

        boolean resultOnProductPage = (regularPriceSizeProductPage.getHeight() < campaignPriceSizeProductPage.getHeight()
                && regularPriceSizeProductPage.getWidth() < campaignPriceSizeProductPage.getWidth());
        Assert.assertTrue(resultOnProductPage);
    }

    public static Color parseColor(String input) {
        System.out.println(input);
        Pattern c = Pattern.compile("rgba? *\\( *([0-9]+), *([0-9]+), *([0-9]+),? *([0-9]+)? *\\)");
        Matcher m = c.matcher(input);

        if (m.matches())
        {
            return new Color(Integer.valueOf(m.group(1)),  // r
                    Integer.valueOf(m.group(2)),  // g
                    Integer.valueOf(m.group(3))); // b
        }

        return null;
    }

}
