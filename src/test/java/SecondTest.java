import Pages.AdminMainPage;
import Pages.LoginToAdminPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SecondTest extends TestBase {

    @Test
    public void testAddNewProduct() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.open();
        AdminMainPage adminMainPage = new

    }
}
