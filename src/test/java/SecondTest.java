import Models.Product;
import Models.ProductBuilder;
import Pages.AddProductPage;
import Pages.AdminMainPage;
import Pages.CatalogPage;
import Pages.LoginToAdminPage;
import org.junit.Test;


public class SecondTest extends TestBase {

    @Test
    public void testAddNewProduct() {
        LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
        loginToAdminPage.open();
        loginToAdminPage.loginAsAdmin();

        AdminMainPage adminMainPage = new AdminMainPage(driver);
        adminMainPage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openNewProductPage();

        Product product = new ProductBuilder()
                .setIsEnabled(true).setName("Donald")
                .setCode("12345")
                .setImageLink(System.getProperty("user.dir") + "/resources/donald.jpg")
                .setIsUnisex(true).setQuantity("123").setManufacturer("ACME Corp.")
                .setDescription("My full name is Donald Fauntleroy Duck")
                .setKeywords("duck donald keywords")
                .setShortDescription("DD short description")
                .setHeadTitle("DONALD head title")
                .setMetaDescription("meta_desc")
                .setDateValidFrom("11/06/2017")
                .setDateValidTo("11/06/2018")
                .setPurchasePrice("1234")
                .setCurrency("Euros")
                .setPriceEur("2222")
                .setPriceUsd("3333")
                .createProduct();

        AddProductPage addProductPage = new AddProductPage(driver);
        addProductPage.fillForm(product);
    }
}
