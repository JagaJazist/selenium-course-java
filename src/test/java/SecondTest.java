import Models.Product;
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

        Product product = new Product(
                true,
                "Donald",
                "12345",
                System.getProperty("user.dir") + "/resources/donald.jpg",
                "123",
                "ACME Corp."
                );

        AddProductPage addProductPage = new AddProductPage(driver);
        addProductPage.fillForm(product);






        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
