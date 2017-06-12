package Pages;

import Models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddProductPage extends PageBase {
    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Product product) {
        fillIsEnabled(product.isEnabled);
        fillName(product.name);
        fillCode(product.code);
        fillImageLink(product.imageLink);
        fillIsUnisex(product.isUnisex);
        fillDateValidFrom(product.dateValidFrom);
        fillDateValidTo(product.dateValidTo);

        openInformationTab();

        fillManufacturer(product.manufacturer);
        fillDescription(product.description);
        fillKeywords(product.keywords);
        fillShortDescription(product.shortDescription);
        fillHeadTitle(product.headTitle);
        fillMetaDescription(product.metaDescription);

        openPricesTab();

        fillPurchacePrice(product.purchasePrice);
        fillCurrency(product.currency);
        fillPriceEur(product.priceEur);
        fillPriceUsd(product.priceUsd);

        submit();
    }

    private void fillPriceUsd(String priceUsd) {
        driver.findElements(By.cssSelector("input[name^=prices]")).get(1).sendKeys(priceUsd);
    }

    private void fillPriceEur(String priceEur) {
        driver.findElements(By.cssSelector("input[name^=prices]")).get(0).sendKeys(priceEur);
    }

    private void fillCurrency(String currency) {
        Select select = new Select(driver.findElement(By.cssSelector("[name=purchase_price_currency_code]")));
        select.selectByVisibleText(currency);

    }

    private void fillPurchacePrice(String purchasePrice) {
        driver.findElement(By.cssSelector("[name=purchase_price]")).sendKeys(purchasePrice);
    }

    private void openPricesTab() {
        driver.findElement(By.linkText("Prices")).click();
    }

    private void fillMetaDescription(String metaDescription) {
        driver.findElement(By.cssSelector("[name^=meta_description]")).sendKeys(metaDescription);
    }

    private void fillHeadTitle(String headTitle) {
        driver.findElement(By.cssSelector("[name^=head_title]")).sendKeys(headTitle);
    }

    private void fillShortDescription(String shortDescription) {
        driver.findElement(By.cssSelector("[name^=short_description]")).sendKeys(shortDescription);
    }

    private void fillKeywords(String keywords) {
        driver.findElement(By.cssSelector("[name=keywords]")).sendKeys(keywords);
    }

    private void fillDateValidTo(String dateValidTo) {
        driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys(dateValidTo);
    }

    private void fillDateValidFrom(String dateValidFrom) {
        driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys(dateValidFrom);
    }

    private void fillIsUnisex(boolean isUnisex) {
        if (isUnisex) {
            driver.findElements(By.cssSelector("[name^=product_groups]")).get(2).click();
        }
    }

    private void fillDescription(String description) {
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(description);
    }

    private void submit() {
        driver.findElement(By.cssSelector("[name=save]")).click();
    }

    private void fillManufacturer(String manufacturer) {
        Select select = new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]")));
        select.selectByVisibleText(manufacturer);
    }

    private void fillImageLink(String imageLink) {
        driver.findElement(By.cssSelector("[name^=new_images]")).sendKeys(imageLink);
    }

    private void fillCode(String code) {
        driver.findElement(By.cssSelector("[name=code]")).sendKeys(code);
    }

    private void fillName(String name) {
        driver.findElement(By.cssSelector("[name^=name]")).sendKeys(name);
    }

    private void fillIsEnabled(boolean isEnabled) {
        if(isEnabled) {
            driver.findElement(By.cssSelector("[name=status]:nth-of-type(1)")).click();
        } else {
            driver.findElement(By.cssSelector("[name=status]:nth-of-type(2)")).click();
        }
    }

    private void openInformationTab() {
        driver.findElement(By.linkText("Information")).click();
    }

}
