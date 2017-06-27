import Models.Product;
import Models.ProductBuilder;
import Pages.AdminEditProductPage;
import Pages.AdminMainPage;
import Pages.AdminCatalogPage;
import Pages.LoginToAdminPage;
import org.junit.Assert;
import org.junit.Test;


public class SecondTest extends TestBase {

    @Test
    public void testAddNewProduct() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.open();
        loginToAdminPage.loginAsAdmin();

        AdminMainPage adminMainPage = new AdminMainPage(driver);
        adminMainPage.openCatalog();

        AdminCatalogPage adminCatalogPage = new AdminCatalogPage(driver);
        adminCatalogPage.openNewProductPage();

        Product product = new ProductBuilder()
                .setIsEnabled(true)
                .setName("Donald")
                .setCode("12345")
                .setImageLink(System.getProperty("user.dir") + "/resources/donald.jpg")
                .setIsUnisex(true).setQuantity("123")
                .setManufacturer("ACME Corp.")
                .setDescription("My full name is Donald Fauntleroy Duck")
                .setKeywords("duck donald keywords")
                .setShortDescription("DD short description")
                .setHeadTitle("DONALD head title")
                .setMetaDescription("meta_desc")
                .setPurchasePrice("1234")
                .setCurrency("Euros")
                .setPriceEur("2222")
                .setPriceUsd("3333")
                .createProduct();

        AdminEditProductPage adminEditProductPage = new AdminEditProductPage(driver);
        adminEditProductPage.addProduct(product);
        adminCatalogPage.openProduct(product);
        Assert.assertTrue(adminEditProductPage.checkName(product.name));
    }
}
