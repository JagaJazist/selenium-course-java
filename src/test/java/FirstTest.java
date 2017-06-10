import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FirstTest extends TestBase {

    public static final String COUNTRIES_URL = "http://localhost:8899/public_html/admin/?app=countries&doc=countries";
    public static final String ZONES_URL = "http://localhost:8899/public_html/admin/?app=geo_zones&doc=geo_zones";


    @Test
    public void testCountriesSorting() {
        loginToAdmin();

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
            }

            driver.get(COUNTRIES_URL);
        }
    }

    @Test
    public void testZonesSorted() {
        loginToAdmin();
        driver.get(ZONES_URL);

        int countriesNum = driver.findElements(By.cssSelector("[name=geo_zones_form] tr")).size();
        for (int i = 2; i < countriesNum; i++) {
            driver.findElement(By.cssSelector("[name=geo_zones_form] tr:nth-of-type(" + i + ") td:nth-of-type(3) a")).click();

            int zonesNum = driver.findElements(By.cssSelector("#table-zones tr")).size();
            System.out.println(zonesNum);
            List<String> zones = new ArrayList<>();
            List<String> sortedZones = new ArrayList<>();

            String currentCountry = driver.findElement(By.cssSelector("[name=name]")).getAttribute("value");

            for (int j = 2; j < zonesNum; j++) {
                Select select = getSelect(j, currentCountry);
                String text = select.getFirstSelectedOption().getText();
                zones.add(text);
                sortedZones.add(text);
//                System.out.println(j + " " +select.getFirstSelectedOption().getText());
            }

            Collections.sort(sortedZones);
            for (int j = 0; j < zones.size(); j++) {
                Assert.assertEquals(zones.get(j), sortedZones.get(j));
            }
            driver.get(ZONES_URL);
        }
    }

    private Select getSelect(int j, String currentCountry) {
        if (currentCountry.equals("European Union")) {
            return new Select(driver.findElement(By.cssSelector("#table-zones tr:nth-of-type(" + j + ") td:nth-of-type(2) select")));
        }
        return new Select(driver.findElement(By.cssSelector("#table-zones tr:nth-of-type(" + j + ") td:nth-of-type(3) select")));
    }

    private void loginToAdmin() {
        driver.get(COUNTRIES_URL);

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
