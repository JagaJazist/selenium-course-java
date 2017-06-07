import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class FirstTest extends TestBase {

    public static final String BASE_URL = "http://localhost:8899/public_html/admin/?app=countries&doc=countries";

    @Test
    public void testCountriesSorting() {
        login();

        List<WebElement> nameElements = driver.findElements(By.cssSelector(".dataTable tr td:nth-of-type(5)"));
        List<WebElement> zonesElements = driver.findElements(By.cssSelector(".dataTable tr td:nth-of-type(6)"));
        if (nameElements.size() != zonesElements.size()) {
            throw new IllegalStateException("Wrong amount of names or zones");
        }
        List<Country> countries = new ArrayList<>();
        List<Country> countryToCheck = new ArrayList<>();
        List<String> sortedNames = new ArrayList<>();

        for (int i = 0; i < nameElements.size(); i++) {
            Country country = new Country(nameElements.get(i).getText(), zonesElements.get(i).getText());
            countries.add(country);
            sortedNames.add(country.name);
            if (!country.zones.equals("0")) {
                System.out.println("Compared: " + country.zones);
                countryToCheck.add(country);
            }
        }
        Collections.sort(sortedNames);

        for (int i = 0; i < countries.size(); i++) {
            Assert.assertEquals(sortedNames.get(i), countries.get(i).name);
        }

        for (Country country: countryToCheck) {
            driver.findElement(By.linkText(country.name)).click();
            wait.until(ExpectedConditions.titleIs("Edit Country | My Store"));
            List<WebElement> regions = driver.findElements(By.cssSelector(".dataTable tr td:nth-of-type(3)"));
            List<String> regionNames = new ArrayList<>();
            List<String> sortedRegionNames = new ArrayList<>();
            for (WebElement region : regions) {
                regionNames.add(region.getText());
                sortedRegionNames.add(region.getText());
            }
            Collections.sort(sortedNames);

            for (int i = 0; i < regionNames.size(); i++) {
                Assert.assertEquals("Regions in " + country.name + "are not sorted",regionNames.get(i), sortedRegionNames.get(i));
                System.out.println("Opened " + country.name);
            }

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
